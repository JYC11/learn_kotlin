kill-daemons:
	gradle --stop && rm -rf ~/.gradle/daemon && gradle --status