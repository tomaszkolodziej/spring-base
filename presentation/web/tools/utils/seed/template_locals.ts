import * as util from 'gulp-util';
import { argv } from 'yargs';
import { join } from 'path';

import Config from '../../config';

const getConfig = (path: string, env: string): any => {
  const configPath = join(path, env);
  let config: any;
  try {
    config = JSON.parse(JSON.stringify(require(configPath)));
  } catch (e) {
    config = null;
    util.log(util.colors.red(e.message));
  }

  return config;
};

/**
 * Returns the project setting (consisting of the base setting provided by seed.config.ts and the additional
 * project specific overrides as defined in project.config.ts)
 */
export function templateLocals() {
  const configEnvName = argv['env-config'] || argv['config-env'] || 'dev';
  const configPath = Config.getPluginConfig('environment-config');
  const baseConfig = getConfig(configPath, 'base');
  const config = getConfig(configPath, configEnvName);

  if (!config) {
    throw new Error('Invalid setting name');
  }

  return Object.assign(Config, {
    ENV_CONFIG: JSON.stringify(Object.assign(baseConfig, config))
  });
}

