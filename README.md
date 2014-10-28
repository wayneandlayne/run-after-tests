Run After Tests
===============

Adam Wolf
Wayne and Layne, LLC
http://www.wayneandlayne.com
v0.1: October 27th 2014

Run After Tests is a small IntelliJ plugin that works with PyCharm and other JetBrains IDEs that runs a command after
a test suite completes.  It runs one command if all the tests passed, and another if any of the tests fail.

The commands are configured in Preferences->Run After Tests.

Installation
============
I need to make sure this works for more than just me before submitting to the JetBrains plugin repository, so for now,
download the RunAfterTests.jar, and install it through your IDE in Preferences->Plugins.

Let me know if it works (or doesn't!) for you.

Developing
==========
I do not know Java beyond writing Android apps, and I do not know hardly anything about IntelliJ, but I was able to
write the first version of this plugin in about one hour.

I was unable to follow the official documentation with regards to getting my development environment set up, simply
because I knew so little about modern Java development or IntelliJ.  However, I was able to follow these instructions:
http://bjorn.tipling.com/how-to-make-an-intellij-idea-plugin-in-30-minutes.

After that, I read a few of the pages here: http://confluence.jetbrains.com/display/IDEADEV/PluginDevelopment, and
did code searches for various APIs that appeared to be useful.

Roadmap
=======
I will probably add a feature to send the total number of tests, passed and failed, and perhaps the name of the failed
tests to the command.

Let me know if there's something you need, and I'll see about adding it.

Licensing
=========
This program is licensed as GPL2.  Please contact me if you are interested in alternate licensing options.
