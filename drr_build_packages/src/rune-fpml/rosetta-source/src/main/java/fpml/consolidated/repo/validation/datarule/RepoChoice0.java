package fpml.consolidated.repo.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.FloatingRateCalculation;
import fpml.consolidated.repo.Repo;
import fpml.consolidated.shared.Frequency;
import fpml.consolidated.shared.Schedule;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RepoChoice0")
@ImplementedBy(RepoChoice0.Default.class)
public interface RepoChoice0 extends Validator<Repo> {
	
	String NAME = "RepoChoice0";
	String DEFINITION = "if fixedRateSchedule exists then floatingRateCalculation is absent and resetFrequency is absent else if floatingRateCalculation exists then fixedRateSchedule is absent else False";
	
	class Default implements RepoChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repo repo) {
			ComparisonResult result = executeDataRule(repo);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Repo", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Repo", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(Repo repo) {
			try {
				if (exists(MapperS.of(repo).<Schedule>map("getFixedRateSchedule", _repo -> _repo.getFixedRateSchedule())).getOrDefault(false)) {
					return notExists(MapperS.of(repo).<FloatingRateCalculation>map("getFloatingRateCalculation", _repo -> _repo.getFloatingRateCalculation())).andNullSafe(notExists(MapperS.of(repo).<Frequency>map("getResetFrequency", _repo -> _repo.getResetFrequency())));
				}
				if (exists(MapperS.of(repo).<FloatingRateCalculation>map("getFloatingRateCalculation", _repo -> _repo.getFloatingRateCalculation())).getOrDefault(false)) {
					return notExists(MapperS.of(repo).<Schedule>map("getFixedRateSchedule", _repo -> _repo.getFixedRateSchedule()));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RepoChoice0 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, Repo repo) {
			return Collections.emptyList();
		}
	}
}
