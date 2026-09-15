package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.SupplementaryData1;
import iso20022.auth030.hkma.dtcc.validation.SupplementaryData1TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.SupplementaryData1Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.SupplementaryData1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SupplementaryData1.class)
public class SupplementaryData1Meta implements RosettaMetaData<SupplementaryData1> {

	@Override
	public List<Validator<? super SupplementaryData1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SupplementaryData1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SupplementaryData1> validator(ValidatorFactory factory) {
		return factory.<SupplementaryData1>create(SupplementaryData1Validator.class);
	}

	@Override
	public Validator<? super SupplementaryData1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SupplementaryData1>create(SupplementaryData1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SupplementaryData1> validator() {
		return new SupplementaryData1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super SupplementaryData1> typeFormatValidator() {
		return new SupplementaryData1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SupplementaryData1, Set<String>> onlyExistsValidator() {
		return new SupplementaryData1OnlyExistsValidator();
	}
}
