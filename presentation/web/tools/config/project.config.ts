import {join} from 'path';

import {SeedConfig} from './seed.config';
// import { ExtendPackages } from './seed.config.interfaces';

/**
 * This class extends the basic seed setting, allowing for project specific overrides. A few examples can be found
 * below.
 */
export class ProjectConfig extends SeedConfig {

    PROJECT_TASKS_DIR = join(process.cwd(), this.TOOLS_DIR, 'tasks', 'project');

    NODE_MODULES = 'node_modules';

    PRIME_NG_THEME = 'bootstrap';

    constructor() {
        super();
        this.APP_TITLE = 'App';

        /* Enable typeless compiler runs (faster) between typed compiler runs. */
        // this.TYPED_COMPILE_INTERVAL = 5;

        // Add `NPM` third-party libraries to be injected/bundled.
        this.NPM_DEPENDENCIES = [
            ...this.NPM_DEPENDENCIES,
            // {src: 'jquery/dist/jquery.min.js', inject: 'libs'},
            // {src: 'lodash/lodash.min.js', inject: 'libs'},
        ];

        // Add `local` third-party libraries to be injected/bundled.
        this.APP_ASSETS = [
            ...this.APP_ASSETS,
            {src: `${this.CSS_SRC}/primeng.min.css`, inject: true, vendor: false},
            {src: `${this.CSS_SRC}/theme.css`, inject: true, vendor: false},
            {src: `${this.CSS_SRC}/font-awesome.min.css`, inject: true, vendor: false},
            {src: `${this.CSS_SRC}/style-material.css`, inject: true, vendor: false},
            {src: this.NODE_MODULES + `/primeng/resources/themes/` + this.PRIME_NG_THEME + `/theme.css`, inject: true, vendor: false},
            {src: this.NODE_MODULES + `/primeng/resources/themes/` + this.PRIME_NG_THEME + `/images/**`, inject: true, vendor: false},
            {src: this.NODE_MODULES + `/font-awesome/css/font-awesome.min.css`, inject: true, vendor: false},
            {src: `${this.APP_SRC}/libs/jquery-3.1.0.min.js`, inject: true, vendor: false}
            // {src: `${this.APP_SRC}/your-path-to-lib/libs/jquery-ui.js`, inject: true, vendor: false}
            // {src: `${this.CSS_SRC}/path-to-lib/test-lib.css`, inject: true, vendor: false},
        ];

        // Add packages (e.g. lodash)
        // let additionalPackages: ExtendPackages[] = [{
        //   name: 'lodash',
        //   path: `${this.APP_BASE}node_modules/lodash/lodash.js`,
        //   packageMeta: {
        //     main: 'index.js',
        //     defaultExtension: 'js'
        //   }
        // }];
        //
        // or
        //
        // let additionalPackages: ExtendPackages[] = [];
        //
        // additionalPackages.push({
        //   name: 'lodash',
        //   path: `${this.APP_BASE}node_modules/lodash/lodash.js`,
        //   packageMeta: {
        //     main: 'index.js',
        //     defaultExtension: 'js'
        //   }
        // });
        //
        // this.addPackagesBundles(additionalPackages);

        /* Add to or override NPM module configurations: */
        // this.mergeObject(this.PLUGIN_CONFIGS['browser-sync'], { ghostMode: false });
    }

}
