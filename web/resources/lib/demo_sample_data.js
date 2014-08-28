function getSampleData() {

    return {
        "data1": [
            // Order is optional. If not specified it will be assigned automatically
            {"id": "2f85dbeb-0845-404e-934e-218bf39750c0", "description": "Qameleon", "order": 0, "tasks": [
                // Dates can be specified as string, timestamp or javascript date object. The data attribute can be used to attach a custom object
                {"id": "f55549b5-e449-4b0c-9f4b-8b33381f7d76", "subject": "Project State: Development", "color": "#93C47D", "from": "2013-10-11T09:00:00", "to": "2013-10-29T10:00:00", "data": "Can contain any custom data or object"},
            ], "data": "Can contain any custom data or object"},
            {"id": "2f85dbeb-0845-404e-934e-218bf39750c1", "description": "Dinozaur", "order": 1, "tasks": [
                // Dates can be specified as string, timestamp or javascript date object. The data attribute can be used to attach a custom object
                {"id": "f55549b5-e449-4b0c-9f4b-8b33381f7d77", "subject": "Project State: Discovery", "color": "#123f7D", "from": "2013-10-09T09:00:00", "to": "2013-10-15T10:00:00", "data": "Can contain any custom data or object"},
            ], "data": "Can contain any custom data or object"}
        ]};
}