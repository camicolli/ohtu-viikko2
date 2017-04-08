Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation successful with correct username and password
        Given new user is selected
        When  username "TamaToimii" and password "salasana1" and confirmation "salasana1" are given
        Then  user is registered

    Scenario: creation fails with correct username and too short password
        Given new user is selected
        When username "TamaToimii" and password "ei1" and confirmation "ei1" are given
        Then user is not created and error "password must be at least 8 characters" is reported

    Scenario: creation fails with too short username and correct password
        Given new user is selected
        When username "ei" and password "tarpeeksipitka1" and confirmation "tarpeeksipitka1" are given
        Then user is not created and error "username should be 3 characters or more" is reported

    Scenario: creation fails with correct username and password with only letters
        Given new user is selected
        When username "TamaToimii" and password "eiolenumeroita" and confirmation "eiolenumeroita" are given
        Then user is not created and error "password has to have other characters than letters" is reported

    Scenario: creation fails with already taken username and valid password
        Given new user is selected
        When  username "jukka" and password "jokusalainen1" and confirmation "jokusalasana1" are given
        Then user is not created and error "username is already taken" is reported

     Scenario: creation fails when password and password confirmation do not match
        Given new user is selected
        When  username "eitoimi" and password "salasana1" and confirmation "eitasmaaekaa1" are given
        Then user is not created and error "password and confirmation do not match" is reported