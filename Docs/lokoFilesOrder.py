"""
FelipedelosH
2026

PUT this file in a FOLDER Files ROOT
the script order a files in folders with same extension name.
"""
from pathlib import Path
import shutil


def organize_files():

    base_path = Path(__file__).resolve().parent
    script_path = Path(__file__).resolve()

    for file in base_path.iterdir():

        # Ignorar carpetas y el propio script
        if not file.is_file() or file == script_path:
            continue

        # Obtener la extension
        extension = file.suffix.lower().lstrip(".")

        if not extension:
            extension = "no_extension"

        # Crear carpeta de destino
        destination_folder = base_path / extension
        destination_folder.mkdir(exist_ok=True)

        destination_file = destination_folder / file.name

        # Evitar sobrescribir archivos existentes
        if destination_file.exists():
            print(f"[SKIPPED] {file.name}: Already exists")
            continue

        # Mover archivo
        shutil.move(str(file), str(destination_file))

        print(f"[MOVED] {file.name} -> {extension}/")

    print("\n[DONE] File organization completed.")


if __name__ == "__main__":
    organize_files()
