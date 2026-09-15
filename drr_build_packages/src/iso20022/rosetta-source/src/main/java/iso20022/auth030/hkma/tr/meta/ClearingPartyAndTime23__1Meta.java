package iso20022.auth030.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.tr.ClearingPartyAndTime23__1;
import iso20022.auth030.hkma.tr.validation.ClearingPartyAndTime23__1TypeFormatValidator;
import iso20022.auth030.hkma.tr.validation.ClearingPartyAndTime23__1Validator;
import iso20022.auth030.hkma.tr.validation.exists.ClearingPartyAndTime23__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ClearingPartyAndTime23__1.class)
public class ClearingPartyAndTime23__1Meta implements RosettaMetaData<ClearingPartyAndTime23__1> {

	@Override
	public List<Validator<? super ClearingPartyAndTime23__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingPartyAndTime23__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingPartyAndTime23__1> validator(ValidatorFactory factory) {
		return factory.<ClearingPartyAndTime23__1>create(ClearingPartyAndTime23__1Validator.class);
	}

	@Override
	public Validator<? super ClearingPartyAndTime23__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingPartyAndTime23__1>create(ClearingPartyAndTime23__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingPartyAndTime23__1> validator() {
		return new ClearingPartyAndTime23__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingPartyAndTime23__1> typeFormatValidator() {
		return new ClearingPartyAndTime23__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingPartyAndTime23__1, Set<String>> onlyExistsValidator() {
		return new ClearingPartyAndTime23__1OnlyExistsValidator();
	}
}
