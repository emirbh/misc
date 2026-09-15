package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.PaperCommodityContainerBoard2;
import iso20022.auth030.esma.validation.PaperCommodityContainerBoard2TypeFormatValidator;
import iso20022.auth030.esma.validation.PaperCommodityContainerBoard2Validator;
import iso20022.auth030.esma.validation.exists.PaperCommodityContainerBoard2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PaperCommodityContainerBoard2.class)
public class PaperCommodityContainerBoard2Meta implements RosettaMetaData<PaperCommodityContainerBoard2> {

	@Override
	public List<Validator<? super PaperCommodityContainerBoard2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PaperCommodityContainerBoard2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PaperCommodityContainerBoard2> validator(ValidatorFactory factory) {
		return factory.<PaperCommodityContainerBoard2>create(PaperCommodityContainerBoard2Validator.class);
	}

	@Override
	public Validator<? super PaperCommodityContainerBoard2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PaperCommodityContainerBoard2>create(PaperCommodityContainerBoard2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityContainerBoard2> validator() {
		return new PaperCommodityContainerBoard2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PaperCommodityContainerBoard2> typeFormatValidator() {
		return new PaperCommodityContainerBoard2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PaperCommodityContainerBoard2, Set<String>> onlyExistsValidator() {
		return new PaperCommodityContainerBoard2OnlyExistsValidator();
	}
}
