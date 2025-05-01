using Microsoft.EntityFrameworkCore;
using CucinaFacile.API.Models;

namespace CucinaFacile.API.Data
{
    public class AppDbContext : DbContext
    {
        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options)
        {
        }

        // DbSets (tables)
        public DbSet<Recipe> Recipes { get; set; }
        public DbSet<Category> Categories { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Seed Categories
            modelBuilder.Entity<Category>().HasData(
                new Category { Id = 1, Name = "Pasta" },
                new Category { Id = 2, Name = "Dolci" }
            );

            // Seed Recipes
            modelBuilder.Entity<Recipe>().HasData(
                new Recipe
                {
                    Id = 1,
                    Name = "Spaghetti Carbonara",
                    Ingredients = "Spaghetti, eggs, guanciale, pecorino cheese, black pepper",
                    Steps = "Boil pasta. Fry guanciale. take guanciale's oil Mix eggs (yolks) and cheese. Combine all.",
                    ImageUrl = "",
                    CategoryId = 1,
                    LanguageCode = "en"
                },
                new Recipe
                {
                    Id = 2,
                    Name = "Tiramisù",
                    Ingredients = "Mascarpone, espresso, ladyfingers, cocoa powder, sugar, eggs",
                    Steps = "Layer soaked ladyfingers and mascarpone mix. Chill. Dust with cocoa.",
                    ImageUrl = "",
                    CategoryId = 2,
                    LanguageCode = "it"
                }
            );
        }
    }
}
