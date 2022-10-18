package com.example.demoyamaha1.utils;

public class VariableUtils {

    // Base variables
    public static final long JWT_EXPIRATION = 604800000L;

    public static final String VAR = "";
    public static final String ID = "id";

    // Table Tickets
    public static final String TICKET_ID = "ticket_id";
    public static final String TABLE_TICKET_LEGAL = "ticket_legal";
    public static final String TABLE_TICKET_ACCT = "ticket_acct";
    public static final String TICKET_PIC = "pic";
    public static final String TICKET_DATE = "date";
    public static final String TICKET_ONTIME = "ontime";
    public static final String TICKET_CHECK = "checked";
    public static final String TICKET_APPROVED = "approved";
    public static final String TICKET_STATUS = "status";
    public static final String TICKET_FK_CONTRACT_ID = "contract_id";
    public static final String TICKET_ASSIGN_DATE = "assign_date";
    public static final String TICKET_COMPLETE_DATE = "complete_date";
    public static final String TICKET_PENDING_AT = "pending_at";
    public static final String TICKET_SCAN_SUBMITTED = "scan_submitted";

    // Table Users
    public static final String TABLE_USER = "users";
    public static final String USER_USERNAME = "username";
    public static final String USER_PASSWORD = "password";
    public static final String USER_EMAIL = "email";
    public static final String USER_STATUS = "status";

    // Table Roles
    public static final String TABLE_ROLES = "roles";
    public static final String ROLE_NAME = "role_name";
    public static final String ROLE_PERMISSION_LEVEL = "permission_level";
    public static final String ROLE_DESCRIPTION = "description";

    // Table User_Role
    public static final String TABLE_USER_ROLE = "users_roles";
    public static final String USER_ROLE_USER_ID = "user_id";
    public static final String USER_ROLE_ROLE_ID = "role_id";

    //Table Contracts
    public static final String TABLE_CONTRACT = "contracts";
    public static final String CONTRACT_NAME = "name";
    public static final String CONTRACT_TYPE = "contract_type";
    public static final String CONTRACT_COUNTERPARTY = "counterparty";
    public static final String CONTRACT_TRANSACTION = "transaction";
    public static final String CONTRACT_START_DATE = "start_date";
    public static final String CONTRACT_EXPIRED_DATE = "expired_date";
    public static final String CONTRACT_AUTOMATIC_RENEWAL = "automatic_renewal";
    public static final String CONTRACT_PIC = "pic";
    public static final String CONTRACT_ORIGINAL_NUM = "original_num";
    public static final String CONTRACT_FILE_LOCATION = "file_location";

}
