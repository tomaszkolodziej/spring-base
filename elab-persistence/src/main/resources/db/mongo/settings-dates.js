//mongeez formatted javascript
//changeset tkolodziej:krotki-i-dlugi-format-daty

db.settings.insert({
    "profileId": null,
    "type": "LONG_DATE_FORMAT",
    "parameter": {
        "_class": "com.tolean.elab.business.impl.profile.setting.impl.LongDateFormatParameter",
        "value": "dd-MM-yyyy HH:mm"
    }
});

db.settings.insert({
    "profileId": null,
    "type": "SHORT_DATE_FORMAT",
    "parameter": {
        "_class": "com.tolean.elab.business.impl.profile.setting.impl.ShortDateFormatParameter",
        "value": "dd-MM-yyyy"
    }
});