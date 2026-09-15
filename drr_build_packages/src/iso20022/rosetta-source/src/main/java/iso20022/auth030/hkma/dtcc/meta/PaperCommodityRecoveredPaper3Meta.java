package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.PaperCommodityRecoveredPaper3;
import iso20022.auth030.hkma.dtcc.validation.PaperCommodityRecoveredPaper3TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.PaperCommodityRecoveredPaper3Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.PaperCommodityRecoveredPaper3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaperCommodityRecoveredPaper3.class)
public class PaperCommodityRecoveredPaper3Meta implements RosettaMetaData<PaperCommodityRecoveredPaper3> {

	@Override
	public List<Validator<? super PaperCommodityRecoveredPaper3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaperCommodityRecoveredPaper3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaperCommodityRecoveredPaper3> validator(ValidatorFactory factory) {
		return factory.<PaperCommodityRecoveredPaper3>create(PaperCommodityRecoveredPaper3Validator.class);
	}

	@Override
	public Validator<? super PaperCommodityRecoveredPaper3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaperCommodityRecoveredPaper3>create(PaperCommodityRecoveredPaper3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityRecoveredPaper3> validator() {
		return new PaperCommodityRecoveredPaper3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityRecoveredPaper3> typeFormatValidator() {
		return new PaperCommodityRecoveredPaper3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaperCommodityRecoveredPaper3, Set<String>> onlyExistsValidator() {
		return new PaperCommodityRecoveredPaper3OnlyExistsValidator();
	}
}
