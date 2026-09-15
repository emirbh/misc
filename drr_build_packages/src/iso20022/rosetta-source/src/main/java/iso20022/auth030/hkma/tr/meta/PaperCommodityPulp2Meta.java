package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.PaperCommodityPulp2;
import iso20022.auth030.hkma.tr.validation.PaperCommodityPulp2TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.PaperCommodityPulp2Validator;
import iso20022.auth030.hkma.tr.validation.exists.PaperCommodityPulp2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaperCommodityPulp2.class)
public class PaperCommodityPulp2Meta implements RosettaMetaData<PaperCommodityPulp2> {

	@Override
	public List<Validator<? super PaperCommodityPulp2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaperCommodityPulp2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaperCommodityPulp2> validator(ValidatorFactory factory) {
		return factory.<PaperCommodityPulp2>create(PaperCommodityPulp2Validator.class);
	}

	@Override
	public Validator<? super PaperCommodityPulp2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaperCommodityPulp2>create(PaperCommodityPulp2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityPulp2> validator() {
		return new PaperCommodityPulp2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityPulp2> typeFormatValidator() {
		return new PaperCommodityPulp2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaperCommodityPulp2, Set<String>> onlyExistsValidator() {
		return new PaperCommodityPulp2OnlyExistsValidator();
	}
}
