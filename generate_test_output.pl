#!/usr/bin/env perl
use strict;
use warnings FATAL => 'all';
use 5.10.1;

use Const::Fast;

const my $ACTIVE_FLAGS          => [qw(false true)];
const my $CONTACT_BY            => [qw(all email none phone)];
const my $START_ID              => 6;

my $EMAIL_ID                    = 4;
my $PHONE_NO                    = 999999999996;

for my $id ($START_ID..1_250_000) {
    $EMAIL_ID += int( rand(3) );
    $PHONE_NO -= int( rand(6) );

    say join(",",
        $id,
        $ACTIVE_FLAGS->[ int( rand(2) ) ],
        $CONTACT_BY->[ int( rand(4) ) ],
        'test' . $EMAIL_ID . '@mail.com',
        '+' . $PHONE_NO,
    );
}