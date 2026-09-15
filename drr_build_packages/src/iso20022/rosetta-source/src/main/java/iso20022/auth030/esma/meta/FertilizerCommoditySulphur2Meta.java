package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.FertilizerCommoditySulphur2;
import iso20022.auth030.esma.validation.FertilizerCommoditySulphur2TypeFormatValidator;
import iso20022.auth030.esma.validation.FertilizerCommoditySulphur2Validator;
import iso20022.auth030.esma.validation.exists.FertilizerCommoditySulphur2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=FertilizerCommoditySulphur2.class)
public class FertilizerCommoditySulphur2Meta implements RosettaMetaData<FertilizerCommoditySulphur2> {

	@Override
	public List<Validator<? super FertilizerCommoditySulphur2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FertilizerCommoditySulphur2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FertilizerCommoditySulphur2> validator(ValidatorFactory factory) {
		return factory.<FertilizerCommoditySulphur2>create(FertilizerCommoditySulphur2Validator.class);
	}

	@Override
	public Validator<? super FertilizerCommoditySulphur2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FertilizerCommoditySulphur2>create(FertilizerCommoditySulphur2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommoditySulphur2> validator() {
		return new FertilizerCommoditySulphur2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super FertilizerCommoditySulphur2> typeFormatValidator() {
		return new FertilizerCommoditySulphur2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FertilizerCommoditySulphur2, Set<String>> onlyExistsValidator() {
		return new FertilizerCommoditySulphur2OnlyExistsValidator();
	}
}
