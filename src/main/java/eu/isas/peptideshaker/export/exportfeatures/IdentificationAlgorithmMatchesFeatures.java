package eu.isas.peptideshaker.export.exportfeatures;

import com.compomics.util.io.export.ExportFeature;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class lists the Algorithm identification features.
 *
 * @author Marc
 */
public enum IdentificationAlgorithmMatchesFeatures implements ExportFeature {

    rank("Rank", "The rank assigned by the identification algorithm.", true),
    accessions("Protein(s)", "Protein(s) to which the peptide can be attached.", false),
    protein_description("Description(s)", "Description of the Protein(s) to which this peptide can be attached.", false),
    sequence("Sequence", "The identified sequence of amino acids.", false),
    missed_cleavages("Missed Cleavages", "The number of missed cleavages.", false),
    modified_sequence("Modified Sequence", "The amino acids sequence annotated with variable modifications.", false),
    variable_ptms("Variable Modifications", "The variable modifications.", false),
    fixed_ptms("Fixed Modifications", "The fixed modifications.", false),
    spectrum_file("Spectrum File", "The spectrum file.", false),
    spectrum_title("Spectrum Title", "The title of the spectrum.", false),
    spectrum_scan_number("Spectrum Scan Number", "The spectrum scan number.", false),
    rt("RT", "Retention time as provided in the spectrum file.", false),
    mz("m/z", "Measured m/z.", false),
    spectrum_charge("Measured Charge", "The charge as given in the spectrum file.", false),
    total_spectrum_intensity("Total Spectrum Intensity", "The summed intensity of all peaks in the spectrum.", true),
    max_intensity("Maximal Spectrum Intensity", "The maximal intensity found in the spectrum.", true),
    identification_charge("Identification Charge", "The charge as inferred by the search engine.", false),
    theoretical_mass("Theoretical Mass", "The theoretical mass of the peptide.", false),
    isotope("Isotope Number", "The isotope number targetted by the instrument.", false),
    mz_error("Precursor m/z Error", "The precursor m/z matching error.", false),
    algorithm_score("Algorithm Score", "Score given by the identification algorithm to the hit independent of modification localization.", false),
    algorithm_confidence("Algorithm Confidence", "Confidence in percent associated to the algorithm score.", false),
    decoy("Decoy", "Indicates whether the peptide is a decoy (1: yes, 0: no).", false),
    validated("Validation", "Indicates the validation level of the protein group.", false),
    starred("Starred", "Indicates whether the match was starred in the interface (1: yes, 0: no).", false),
    hidden("Hidden", "Indicates whether the match was hidden in the interface (1: yes, 0: no).", false);
    /**
     * The title of the feature which will be used for column heading.
     */
    public String title;
    /**
     * The description of the feature.
     */
    public String description;
    /**
     * The type of export feature.
     */
    public final static String type = "Identification Algorithm Results";
    /**
     * indicates whether a feature is for advanced user only
     */
    private boolean advanced;

    /**
     * Constructor.
     *
     * @param title title of the feature
     * @param description description of the feature
     * @param advanced indicates whether a feature is for advanced user only
     */
    private IdentificationAlgorithmMatchesFeatures(String title, String description, boolean advanced) {
        this.title = title;
        this.description = description;
        this.advanced = advanced;
    }

    @Override
    public ArrayList<ExportFeature> getExportFeatures(boolean includeSubFeatures) {
        ArrayList<ExportFeature> result = new ArrayList<ExportFeature>();
        result.addAll(Arrays.asList(values()));
        if (includeSubFeatures) {
        result.addAll(FragmentFeatures.values()[0].getExportFeatures(includeSubFeatures));
        }
        return result;
    }

    @Override
    public String[] getTitles() {
        return new String[]{title};
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getFeatureFamily() {
        return type;
    }

    @Override
    public boolean isAdvanced() {
        return advanced;
    }
}
