using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace CucinaFacile.API.Migrations
{
    /// <inheritdoc />
    public partial class SeedData : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.InsertData(
                table: "Categories",
                columns: new[] { "Id", "Name" },
                values: new object[,]
                {
                    { 1, "Pasta" },
                    { 2, "Dolci" }
                });

            migrationBuilder.InsertData(
                table: "Recipes",
                columns: new[] { "Id", "CategoryId", "ImageUrl", "Ingredients", "LanguageCode", "Name", "Steps" },
                values: new object[,]
                {
                    { 1, 1, "", "Spaghetti, eggs, guanciale, pecorino cheese, black pepper", "en", "Spaghetti Carbonara", "Boil pasta. Fry guanciale. take guanciale's oil Mix eggs (yolks) and cheese. Combine all." },
                    { 2, 2, "", "Mascarpone, espresso, ladyfingers, cocoa powder, sugar, eggs", "it", "Tiramisù", "Layer soaked ladyfingers and mascarpone mix. Chill. Dust with cocoa." }
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DeleteData(
                table: "Recipes",
                keyColumn: "Id",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Recipes",
                keyColumn: "Id",
                keyValue: 2);

            migrationBuilder.DeleteData(
                table: "Categories",
                keyColumn: "Id",
                keyValue: 1);

            migrationBuilder.DeleteData(
                table: "Categories",
                keyColumn: "Id",
                keyValue: 2);
        }
    }
}
