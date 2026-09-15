package iso20022.auth030.hkma.dtcc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.hkma.dtcc.LegalPersonIdentification1__3;
import iso20022.auth030.hkma.dtcc.validation.LegalPersonIdentification1__3TypeFormatValidator;
import iso20022.auth030.hkma.dtcc.validation.LegalPersonIdentification1__3Validator;
import iso20022.auth030.hkma.dtcc.validation.exists.LegalPersonIdentification1__3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=LegalPersonIdentification1__3.class)
public class LegalPersonIdentification1__3Meta implements RosettaMetaData<LegalPersonIdentification1__3> {

	@Override
	public List<Validator<? super LegalPersonIdentification1__3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LegalPersonIdentification1__3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegalPersonIdentification1__3> validator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1__3>create(LegalPersonIdentification1__3Validator.class);
	}

	@Override
	public Validator<? super LegalPersonIdentification1__3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegalPersonIdentification1__3>create(LegalPersonIdentification1__3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1__3> validator() {
		return new LegalPersonIdentification1__3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super LegalPersonIdentification1__3> typeFormatValidator() {
		return new LegalPersonIdentification1__3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegalPersonIdentification1__3, Set<String>> onlyExistsValidator() {
		return new LegalPersonIdentification1__3OnlyExistsValidator();
	}
}
