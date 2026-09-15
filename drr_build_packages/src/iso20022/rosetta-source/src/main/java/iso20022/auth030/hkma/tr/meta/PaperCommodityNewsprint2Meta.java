package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.PaperCommodityNewsprint2;
import iso20022.auth030.hkma.tr.validation.PaperCommodityNewsprint2TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.PaperCommodityNewsprint2Validator;
import iso20022.auth030.hkma.tr.validation.exists.PaperCommodityNewsprint2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaperCommodityNewsprint2.class)
public class PaperCommodityNewsprint2Meta implements RosettaMetaData<PaperCommodityNewsprint2> {

	@Override
	public List<Validator<? super PaperCommodityNewsprint2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaperCommodityNewsprint2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaperCommodityNewsprint2> validator(ValidatorFactory factory) {
		return factory.<PaperCommodityNewsprint2>create(PaperCommodityNewsprint2Validator.class);
	}

	@Override
	public Validator<? super PaperCommodityNewsprint2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaperCommodityNewsprint2>create(PaperCommodityNewsprint2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityNewsprint2> validator() {
		return new PaperCommodityNewsprint2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityNewsprint2> typeFormatValidator() {
		return new PaperCommodityNewsprint2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaperCommodityNewsprint2, Set<String>> onlyExistsValidator() {
		return new PaperCommodityNewsprint2OnlyExistsValidator();
	}
}
