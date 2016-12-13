CREATE TABLE "celect_user" (
	"id" SERIAL NOT NULL UNIQUE,
	"phone_number" varchar(11) NOT NULL UNIQUE,
	CONSTRAINT celect_user_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "interview" (
	"id" SERIAL NOT NULL,
	"info" TEXT UNIQUE,
	CONSTRAINT interview_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "case" (
	"id" SERIAL NOT NULL,
	"main_info" varchar(140) NOT NULL UNIQUE,
	"full_info" TEXT,
	"interview_id" integer NOT NULL,
	CONSTRAINT case_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "elections" (
	"interview_id" integer NOT NULL,
	"case_id" integer NOT NULL,
	"user_id" integer NOT NULL
) WITH (
  OIDS=FALSE
);





ALTER TABLE "case" ADD CONSTRAINT "case_fk0" FOREIGN KEY ("interview_id") REFERENCES "interview"("id");

ALTER TABLE "elections" ADD CONSTRAINT "elections_fk0" FOREIGN KEY ("interview_id") REFERENCES "interview"("id");
ALTER TABLE "elections" ADD CONSTRAINT "elections_fk1" FOREIGN KEY ("case_id") REFERENCES "case"("id");
ALTER TABLE "elections" ADD CONSTRAINT "elections_fk2" FOREIGN KEY ("user_id") REFERENCES "celect_user"("id");
ALTER TABLE elections ADD UNIQUE (user_id, interview_id)

