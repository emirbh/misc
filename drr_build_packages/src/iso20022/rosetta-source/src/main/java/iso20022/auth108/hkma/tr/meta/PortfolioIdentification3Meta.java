package iso20022.auth108.hkma.tr.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth108.hkma.tr.PortfolioIdentification3;
import iso20022.auth108.hkma.tr.validation.PortfolioIdentification3TypeFormatValidator;
import iso20022.auth108.hkma.tr.validation.PortfolioIdentification3Validator;
import iso20022.auth108.hkma.tr.validation.exists.PortfolioIdentification3OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PortfolioIdentification3.class)
public class PortfolioIdentification3Meta implements RosettaMetaData<PortfolioIdentification3> {

	@Override
	public List<Validator<? super PortfolioIdentification3>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PortfolioIdentification3, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PortfolioIdentification3> validator(ValidatorFactory factory) {
		return factory.<PortfolioIdentification3>create(PortfolioIdentification3Validator.class);
	}

	@Override
	public Validator<? super PortfolioIdentification3> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PortfolioIdentification3>create(PortfolioIdentification3TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioIdentification3> validator() {
		return new PortfolioIdentification3Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PortfolioIdentification3> typeFormatValidator() {
		return new PortfolioIdentification3TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PortfolioIdentification3, Set<String>> onlyExistsValidator() {
		return new PortfolioIdentification3OnlyExistsValidator();
	}
}
