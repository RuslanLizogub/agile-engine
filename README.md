Run E2E
--------------------
UI(ytrbqduzze_1561654865@tfbnw.net/Qwerty123@):

    $ gradle clean test -Pui
    
API(rkagobajmj_1561741787@tfbnw.net/Qwerty123@): 

    $ gradle clean test -Papi
    

# Requirements

- java 8
- gradle

# Task
Write Create/Update/Delete tests for a single Facebook post on Facebook (ability to create/update/delete post using Facebook API (API tests, UI - Selenium)

Note: Please use Facebook Test Users/Pages for automation.

Tests must be written in Java/Python. Test coverage should be defined by yourself. It is important to have proper test coverage. All tests should pass successfully.

Please, define Java/Python version and lib versions properly via your building tool so that we don’t need to configure it locally.

FAQ:
Do I need to create FB app and have it been reviewed by FB?
No, you can create Facebook Test App in your Dev Account without any reviewing required.

Facebook does not allow to make POST requests. Is it?
FB does not allow to make POST to the real dev apps, but if you use Test Apps connected to your real account it’s fully available. It was created exactly for debugging purposes.

Also, please, use Graph API Tool to generate Page Access token with required permissions. You need your created Test App and Created Test Page ids. 

This tech task is really can be completed. It is not blocked by any FB restrictions (not yet :) )
