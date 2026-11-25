$ErrorActionPreference = 'Stop'
Set-Location $PSScriptRoot

$version = 17
$javaHome = [Environment]::GetEnvironmentVariable("JAVA_HOME_$version")
if (-not $javaHome) { $javaHome = $env:JAVA_HOME }
if ($javaHome) {
    $java = Join-Path $javaHome 'bin\java.exe'
    $javac = Join-Path $javaHome 'bin\javac.exe'
} else {
    $java = 'java.exe'
    $javac = 'javac.exe'
}
$javaVersion = & $java --version | Select-Object -First 1
$javacVersion = & $javac -version | Select-Object -First 1
if ($javaVersion -notmatch "\s$version(?:\.|\s|$)" -or $javacVersion -notmatch "\s$version(?:\.|\s|$)") {
    throw "JDK $version required. Set JAVA_HOME_$version to its installation directory."
}
$classes = Join-Path $PSScriptRoot "build\classes-java$version"
New-Item -ItemType Directory -Force -Path $classes | Out-Null
$files = @(Get-ChildItem -Path '.\src\main\java' -Recurse -Filter '*.java' | ForEach-Object { $_.FullName })
& $javac --release $version -encoding UTF-8 -d $classes @files
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
& $java -cp "$classes;$PSScriptRoot\src\main\resources" Main
exit $LASTEXITCODE
