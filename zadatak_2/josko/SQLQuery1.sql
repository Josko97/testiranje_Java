use ASR_JRN;

CREATE TABLE RecordHeader (
    TransactionId INT IDENTITY(1,1) PRIMARY KEY,
    BranchNumber VARCHAR(4),
    POSTerminal VARCHAR(3),
    DateTime VARCHAR(14),
    ReceiptNumber VARCHAR(4),
    ItemSequence VARCHAR(3)
);

CREATE TABLE IDC_F (
    id INT IDENTITY(1,1) PRIMARY KEY,
    CashierNumber VARCHAR(4),
    ItemCounter VARCHAR(8),
    TotalPrice decimal(8,2)
);

CREATE TABLE IDC_S (
    id INT IDENTITY(1,1) PRIMARY KEY,
	DepartmentNumber char(4) not null,
	PLUNumber varchar(16) null,
	Quantity int null,
	Weight int null,
	AmountAbsolute int not null,
	OriginalItemPrice int null,
	ArticleDescription varchar(80) null
);

CREATE TABLE IDC_W (
    id INT IDENTITY(1,1) PRIMARY KEY,
	ItemInfo varchar(4) not null,
	EanUpc varchar(16),
	AgeRestriction varchar(1),
	Amount int 
);

drop table IDC_W;

CREATE TABLE IDC_T (
    id INT IDENTITY(1,1) PRIMARY KEY,
	CashierNumber VARCHAR(4),
	AdditionalInformation varchar(16) null,
	TenderNumber varchar(2) null,
	Counter varchar(6) null,
	AmountOfPayment int null
);

drop table IDC_T;

CREATE TABLE IDC_H (
    id INT IDENTITY(1,1) PRIMARY KEY,
	CashierNumber VARCHAR(4),
	AdditionalInformation varchar(8) null,
	ItemCounter VARCHAR(6),
	TotalValue decimal(8,2)
);

ALTER TABLE IDC_F
ADD TransactionId INT;

ALTER TABLE IDC_F
ADD CONSTRAINT FK_IDC_F_RecordHeader
FOREIGN KEY (TransactionId) REFERENCES RecordHeader(TransactionId);


ALTER TABLE IDC_S
ADD TransactionId INT;

ALTER TABLE IDC_S
ADD CONSTRAINT FK_IDC_S_RecordHeader
FOREIGN KEY (TransactionId) REFERENCES RecordHeader(TransactionId);


ALTER TABLE IDC_W
ADD TransactionId INT;

ALTER TABLE IDC_W
ADD CONSTRAINT FK_IDC_W_RecordHeader
FOREIGN KEY (TransactionId) REFERENCES RecordHeader(TransactionId);


ALTER TABLE IDC_T
ADD TransactionId INT;

ALTER TABLE IDC_T
ADD CONSTRAINT FK_IDC_T_RecordHeader
FOREIGN KEY (TransactionId) REFERENCES RecordHeader(TransactionId);

ALTER TABLE IDC_H
ADD TransactionId INT;

ALTER TABLE IDC_H
ADD CONSTRAINT FK_IDC_H_RecordHeader
FOREIGN KEY (TransactionId) REFERENCES RecordHeader(TransactionId); 

delete from RecordHeader;

delete from IDC_F;