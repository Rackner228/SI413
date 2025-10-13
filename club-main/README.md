# club

Command Line sUBmit script

![Club Mascot](bambam.png)

## Overview

[submit]: https://submit.cs.usna.edu
[club]: https://gitlab.usna.edu/roche/club

`club` is an interactive bash script that lets you do the following
with the [CS department's submit server][submit] from the comfort of
your terminal:

+   Submit files for an assignment
+   See the results of auto-testing
+   (For instructors): submit or view auto-testing for any of your students

If you notice something that doesn't work or could work better, you can
[use the gitlab site][club] to submit an issue or, better yet, fix it
yourself and submit a merge request!

## Installation

`club` is a single self-contained executable bash script.
You just need to clone this repository (or download that single file)
and put `club` into your `PATH`.

This should do that for you:

    git clone https://gitlab.usna.edu/roche/club.git ~/.club
    mkdir -p ~/bin
    ln -s ../.club/club ~/bin/club

Then you can run club by typing `~/bin/club` at the command line.
If your `$HOME/bin` directory is in your `PATH` (and it should be), then
you can just type `club`.

## Usage

`club` works best if you make a new directory for each assignment in a
class. Once you're in the directory for some assignment, just run `club`
and specify the files you want to submit, like:

    club myprogram.cpp myotherfile.txt

The first time you run `club` in a directory, it will ask you to say
what is the name of the course and assignment. These are saved in a
hidden file called `.clubinfo` so you don't have to enter them the next
time you run `club` in the same directory.

To check the auto-testing results without re-submitting, just run

    club

Here is the full usage information, which you can also see by running
`club -h`:

    club: Command Line sUBmit script v1.5

    Used to submit and/or see test case results for the USNA CS Department submit system.

    Usage: club [FILES ...]

    With FILES, tries to submit those files for some assignment and then show
    the auto-testing results.

    With no FILES given, just checks the test results of a previous submission.

    The hidden file .clubinfo will created in the directory the first time you run
    this, and will be used in later runs to determine the course and project.

    OPTIONS:
      -cCOURSE or --course=COURSE
          Specify which course, e.g., "-c ic210"
      -pPROJECT or --project=PROJECT
          Specify which project, e.g., "-p lab01"
      -s[SID] or --sid[=SID]
          Check a prior submission according to the given SID.
          If you don't know the SID, just use "-s" and you can choose from a list.
      -uUSER or --user=USER
          Specify the username to use, e.g., "-u m123456".
          The default is yourself; this option is only useful for instructors!
      -nNAMESFILE or --names=NAMESFILE
        The file should contain lines "username displayname", like
          m123456 MIDN Soandso
        and then the system will show the displayname instead of the username when relevant.
      -f or --full
        Upload files with the full pathname given on the command line,
        like a/b/somefile.txt instead of just somefile.txt
      -r
        Before doing anything else, try to update ("refresh") club itself from gitlab
      -h or --help
          Display this help message and exit

    club was written by Dr. Roche in September 2021. Use the gitlab page to
    submit bug reports, or make your own improvements and submit a merge request:
      https://gitlab.usna.edu/roche/club

## bulc

`bulc` is the opposite of club: it downloads submission(s) from the
submit system to the local computer. It's mostly useful for instructors.

It exists as another standalone bash script. To install it, first
install club according to the instructions above, and then run

    ln -s ../.club/bulc ~/bin/bulc

Type `bulc -h` for usage info.

**New in v1.5**: `bulc` downloads and summarizes autotest results in
addition to the actual uploaded files.

**New in v1.6**: `bulc` now supports historic project downloads
