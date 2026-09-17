package cdm.product.template.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.product.template.ExerciseNotice;
import cdm.product.template.ManualExercise;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ManualExerciseManualExerciseNoticeReceiverParty")
@ImplementedBy(ManualExerciseManualExerciseNoticeReceiverParty.Default.class)
public interface ManualExerciseManualExerciseNoticeReceiverParty extends Validator<ManualExercise> {
	
	String NAME = "ManualExerciseManualExerciseNoticeReceiverParty";
	String DEFINITION = "if exerciseNotice -> exerciseNoticeReceiver exists then exerciseNotice -> exerciseNoticeReceiver = AncillaryRoleEnum -> ExerciseNoticeReceiverPartyManual";
	
	class Default implements ManualExerciseManualExerciseNoticeReceiverParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ManualExercise manualExercise) {
			ComparisonResult result = executeDataRule(manualExercise);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ManualExercise", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ManualExercise", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ManualExercise manualExercise) {
			try {
				if (exists(MapperS.of(manualExercise).<ExerciseNotice>map("getExerciseNotice", _manualExercise -> _manualExercise.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", exerciseNotice -> exerciseNotice.getExerciseNoticeReceiver())).getOrDefault(false)) {
					return areEqual(MapperS.of(manualExercise).<ExerciseNotice>map("getExerciseNotice", _manualExercise -> _manualExercise.getExerciseNotice()).<AncillaryRoleEnum>map("getExerciseNoticeReceiver", exerciseNotice -> exerciseNotice.getExerciseNoticeReceiver()), MapperS.of(AncillaryRoleEnum.EXERCISE_NOTICE_RECEIVER_PARTY_MANUAL), CardinalityOperator.All);
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ManualExerciseManualExerciseNoticeReceiverParty {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ManualExercise manualExercise) {
			return Collections.emptyList();
		}
	}
}
