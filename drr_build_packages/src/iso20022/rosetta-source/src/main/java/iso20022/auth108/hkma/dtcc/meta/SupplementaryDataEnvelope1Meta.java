package iso20022.auth108.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.dtcc.SupplementaryDataEnvelope1;
import iso20022.auth108.hkma.dtcc.validation.SupplementaryDataEnvelope1TypeFormatValidator;
import iso20022.auth108.hkma.dtcc.validation.SupplementaryDataEnvelope1Validator;
import iso20022.auth108.hkma.dtcc.validation.exists.SupplementaryDataEnvelope1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SupplementaryDataEnvelope1.class)
public class SupplementaryDataEnvelope1Meta implements RosettaMetaData<SupplementaryDataEnvelope1> {

	@Override
	public List<Validator<? super SupplementaryDataEnvelope1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SupplementaryDataEnvelope1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SupplementaryDataEnvelope1> validator(ValidatorFactory factory) {
		return factory.<SupplementaryDataEnvelope1>create(SupplementaryDataEnvelope1Validator.class);
	}

	@Override
	public Validator<? super SupplementaryDataEnvelope1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SupplementaryDataEnvelope1>create(SupplementaryDataEnvelope1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SupplementaryDataEnvelope1> validator() {
		return new SupplementaryDataEnvelope1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super SupplementaryDataEnvelope1> typeFormatValidator() {
		return new SupplementaryDataEnvelope1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SupplementaryDataEnvelope1, Set<String>> onlyExistsValidator() {
		return new SupplementaryDataEnvelope1OnlyExistsValidator();
	}
}
