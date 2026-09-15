package fpml.consolidated.business.events;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.business.events.meta.ActionOnExpirationMeta;
import fpml.consolidated.fpmlenum.ExerciseActionEnum;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision 
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision 
 *
 */
@RosettaDataType(value="ActionOnExpiration", builder=ActionOnExpiration.ActionOnExpirationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ActionOnExpiration", model="fpml", builder=ActionOnExpiration.ActionOnExpirationBuilderImpl.class, version="2.1.1")
public interface ActionOnExpiration extends RosettaModelObject {

	ActionOnExpirationMeta metaData = new ActionOnExpirationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	ExerciseActionEnum getExerciseAction();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Boolean getExpiry();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Boolean getFullExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as notional amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as notional amount.
	 *
	 */
	Money getExerciseInNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Notional amount after the Change
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Notional amount after the Change
	 *
	 */
	Money getOutstandingNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as number of options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised expressed as number of options.
	 *
	 */
	BigDecimal getExerciseInNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Options after the Change.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Options after the Change.
	 *
	 */
	BigDecimal getOutstandingNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised express as number of units.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the fixed amount by which the option should be exercised express as number of units.
	 *
	 */
	BigDecimal getExerciseInNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 */
	BigDecimal getOutstandingNumberOfUnits();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the Number of Units
	 *
	 */
	List<? extends OptionExerciseAmounts> getSpecifiedExercise();

	/*********************** Build Methods  ***********************/
	ActionOnExpiration build();
	
	ActionOnExpiration.ActionOnExpirationBuilder toBuilder();
	
	static ActionOnExpiration.ActionOnExpirationBuilder builder() {
		return new ActionOnExpiration.ActionOnExpirationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ActionOnExpiration> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ActionOnExpiration> getType() {
		return ActionOnExpiration.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("exerciseAction"), ExerciseActionEnum.class, getExerciseAction(), this);
		processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
		processor.processBasic(path.newSubPath("fullExercise"), Boolean.class, getFullExercise(), this);
		processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.class, getExerciseInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.class, getOutstandingNotionalAmount());
		processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		processRosetta(path.newSubPath("specifiedExercise"), processor, OptionExerciseAmounts.class, getSpecifiedExercise());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ActionOnExpirationBuilder extends ActionOnExpiration, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateExerciseInNotionalAmount();
		@Override
		Money.MoneyBuilder getExerciseInNotionalAmount();
		Money.MoneyBuilder getOrCreateOutstandingNotionalAmount();
		@Override
		Money.MoneyBuilder getOutstandingNotionalAmount();
		OptionExerciseAmounts.OptionExerciseAmountsBuilder getOrCreateSpecifiedExercise(int index);
		@Override
		List<? extends OptionExerciseAmounts.OptionExerciseAmountsBuilder> getSpecifiedExercise();
		ActionOnExpiration.ActionOnExpirationBuilder setExerciseAction(ExerciseActionEnum exerciseAction);
		ActionOnExpiration.ActionOnExpirationBuilder setExpiry(Boolean expiry);
		ActionOnExpiration.ActionOnExpirationBuilder setFullExercise(Boolean fullExercise);
		ActionOnExpiration.ActionOnExpirationBuilder setExerciseInNotionalAmount(Money exerciseInNotionalAmount);
		ActionOnExpiration.ActionOnExpirationBuilder setOutstandingNotionalAmount(Money outstandingNotionalAmount);
		ActionOnExpiration.ActionOnExpirationBuilder setExerciseInNumberOfOptions(BigDecimal exerciseInNumberOfOptions);
		ActionOnExpiration.ActionOnExpirationBuilder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);
		ActionOnExpiration.ActionOnExpirationBuilder setExerciseInNumberOfUnits(BigDecimal exerciseInNumberOfUnits);
		ActionOnExpiration.ActionOnExpirationBuilder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);
		ActionOnExpiration.ActionOnExpirationBuilder addSpecifiedExercise(OptionExerciseAmounts specifiedExercise);
		ActionOnExpiration.ActionOnExpirationBuilder addSpecifiedExercise(OptionExerciseAmounts specifiedExercise, int idx);
		ActionOnExpiration.ActionOnExpirationBuilder addSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercise);
		ActionOnExpiration.ActionOnExpirationBuilder setSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercise);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("exerciseAction"), ExerciseActionEnum.class, getExerciseAction(), this);
			processor.processBasic(path.newSubPath("expiry"), Boolean.class, getExpiry(), this);
			processor.processBasic(path.newSubPath("fullExercise"), Boolean.class, getFullExercise(), this);
			processRosetta(path.newSubPath("exerciseInNotionalAmount"), processor, Money.MoneyBuilder.class, getExerciseInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, Money.MoneyBuilder.class, getOutstandingNotionalAmount());
			processor.processBasic(path.newSubPath("exerciseInNumberOfOptions"), BigDecimal.class, getExerciseInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("exerciseInNumberOfUnits"), BigDecimal.class, getExerciseInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
			processRosetta(path.newSubPath("specifiedExercise"), processor, OptionExerciseAmounts.OptionExerciseAmountsBuilder.class, getSpecifiedExercise());
		}
		

		ActionOnExpiration.ActionOnExpirationBuilder prune();
	}

	/*********************** Immutable Implementation of ActionOnExpiration  ***********************/
	class ActionOnExpirationImpl implements ActionOnExpiration {
		private final ExerciseActionEnum exerciseAction;
		private final Boolean expiry;
		private final Boolean fullExercise;
		private final Money exerciseInNotionalAmount;
		private final Money outstandingNotionalAmount;
		private final BigDecimal exerciseInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		private final BigDecimal exerciseInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		private final List<? extends OptionExerciseAmounts> specifiedExercise;
		
		protected ActionOnExpirationImpl(ActionOnExpiration.ActionOnExpirationBuilder builder) {
			this.exerciseAction = builder.getExerciseAction();
			this.expiry = builder.getExpiry();
			this.fullExercise = builder.getFullExercise();
			this.exerciseInNotionalAmount = ofNullable(builder.getExerciseInNotionalAmount()).map(f->f.build()).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).map(f->f.build()).orElse(null);
			this.exerciseInNumberOfOptions = builder.getExerciseInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
			this.exerciseInNumberOfUnits = builder.getExerciseInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
			this.specifiedExercise = ofNullable(builder.getSpecifiedExercise()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exerciseAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseAction")
		public ExerciseActionEnum getExerciseAction() {
			return exerciseAction;
		}
		
		@Override
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		@RosettaAttribute("fullExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullExercise")
		public Boolean getFullExercise() {
			return fullExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		public Money getExerciseInNotionalAmount() {
			return exerciseInNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalAmount")
		public Money getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		public BigDecimal getExerciseInNumberOfOptions() {
			return exerciseInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		public BigDecimal getExerciseInNumberOfUnits() {
			return exerciseInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("specifiedExercise")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedExercise")
		public List<? extends OptionExerciseAmounts> getSpecifiedExercise() {
			return specifiedExercise;
		}
		
		@Override
		public ActionOnExpiration build() {
			return this;
		}
		
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder toBuilder() {
			ActionOnExpiration.ActionOnExpirationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ActionOnExpiration.ActionOnExpirationBuilder builder) {
			ofNullable(getExerciseAction()).ifPresent(builder::setExerciseAction);
			ofNullable(getExpiry()).ifPresent(builder::setExpiry);
			ofNullable(getFullExercise()).ifPresent(builder::setFullExercise);
			ofNullable(getExerciseInNotionalAmount()).ifPresent(builder::setExerciseInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
			ofNullable(getExerciseInNumberOfOptions()).ifPresent(builder::setExerciseInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
			ofNullable(getExerciseInNumberOfUnits()).ifPresent(builder::setExerciseInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
			ofNullable(getSpecifiedExercise()).ifPresent(builder::setSpecifiedExercise);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionOnExpiration _that = getType().cast(o);
		
			if (!Objects.equals(exerciseAction, _that.getExerciseAction())) return false;
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			if (!Objects.equals(fullExercise, _that.getFullExercise())) return false;
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			if (!ListEquals.listEquals(specifiedExercise, _that.getSpecifiedExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseAction != null ? exerciseAction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			_result = 31 * _result + (fullExercise != null ? fullExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (specifiedExercise != null ? specifiedExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionOnExpiration {" +
				"exerciseAction=" + this.exerciseAction + ", " +
				"expiry=" + this.expiry + ", " +
				"fullExercise=" + this.fullExercise + ", " +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits + ", " +
				"specifiedExercise=" + this.specifiedExercise +
			'}';
		}
	}

	/*********************** Builder Implementation of ActionOnExpiration  ***********************/
	class ActionOnExpirationBuilderImpl implements ActionOnExpiration.ActionOnExpirationBuilder {
	
		protected ExerciseActionEnum exerciseAction;
		protected Boolean expiry;
		protected Boolean fullExercise;
		protected Money.MoneyBuilder exerciseInNotionalAmount;
		protected Money.MoneyBuilder outstandingNotionalAmount;
		protected BigDecimal exerciseInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
		protected BigDecimal exerciseInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
		protected List<OptionExerciseAmounts.OptionExerciseAmountsBuilder> specifiedExercise = new ArrayList<>();
		
		@Override
		@RosettaAttribute("exerciseAction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseAction")
		public ExerciseActionEnum getExerciseAction() {
			return exerciseAction;
		}
		
		@Override
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiry")
		public Boolean getExpiry() {
			return expiry;
		}
		
		@Override
		@RosettaAttribute("fullExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("fullExercise")
		public Boolean getFullExercise() {
			return fullExercise;
		}
		
		@Override
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		public Money.MoneyBuilder getExerciseInNotionalAmount() {
			return exerciseInNotionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateExerciseInNotionalAmount() {
			Money.MoneyBuilder result;
			if (exerciseInNotionalAmount!=null) {
				result = exerciseInNotionalAmount;
			}
			else {
				result = exerciseInNotionalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNotionalAmount")
		public Money.MoneyBuilder getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateOutstandingNotionalAmount() {
			Money.MoneyBuilder result;
			if (outstandingNotionalAmount!=null) {
				result = outstandingNotionalAmount;
			}
			else {
				result = outstandingNotionalAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		public BigDecimal getExerciseInNumberOfOptions() {
			return exerciseInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		public BigDecimal getExerciseInNumberOfUnits() {
			return exerciseInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("specifiedExercise")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("specifiedExercise")
		public List<? extends OptionExerciseAmounts.OptionExerciseAmountsBuilder> getSpecifiedExercise() {
			return specifiedExercise;
		}
		
		@Override
		public OptionExerciseAmounts.OptionExerciseAmountsBuilder getOrCreateSpecifiedExercise(int index) {
			if (specifiedExercise==null) {
				this.specifiedExercise = new ArrayList<>();
			}
			return getIndex(specifiedExercise, index, () -> {
						OptionExerciseAmounts.OptionExerciseAmountsBuilder newSpecifiedExercise = OptionExerciseAmounts.builder();
						return newSpecifiedExercise;
					});
		}
		
		@RosettaAttribute("exerciseAction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseAction")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setExerciseAction(ExerciseActionEnum _exerciseAction) {
			this.exerciseAction = _exerciseAction == null ? null : _exerciseAction;
			return this;
		}
		
		@RosettaAttribute("expiry")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiry")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setExpiry(Boolean _expiry) {
			this.expiry = _expiry == null ? null : _expiry;
			return this;
		}
		
		@RosettaAttribute("fullExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("fullExercise")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setFullExercise(Boolean _fullExercise) {
			this.fullExercise = _fullExercise == null ? null : _fullExercise;
			return this;
		}
		
		@RosettaAttribute("exerciseInNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNotionalAmount")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setExerciseInNotionalAmount(Money _exerciseInNotionalAmount) {
			this.exerciseInNotionalAmount = _exerciseInNotionalAmount == null ? null : _exerciseInNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("outstandingNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNotionalAmount")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setOutstandingNotionalAmount(Money _outstandingNotionalAmount) {
			this.outstandingNotionalAmount = _outstandingNotionalAmount == null ? null : _outstandingNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseInNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNumberOfOptions")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setExerciseInNumberOfOptions(BigDecimal _exerciseInNumberOfOptions) {
			this.exerciseInNumberOfOptions = _exerciseInNumberOfOptions == null ? null : _exerciseInNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfOptions")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setOutstandingNumberOfOptions(BigDecimal _outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = _outstandingNumberOfOptions == null ? null : _outstandingNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("exerciseInNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseInNumberOfUnits")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setExerciseInNumberOfUnits(BigDecimal _exerciseInNumberOfUnits) {
			this.exerciseInNumberOfUnits = _exerciseInNumberOfUnits == null ? null : _exerciseInNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("outstandingNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("outstandingNumberOfUnits")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setOutstandingNumberOfUnits(BigDecimal _outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = _outstandingNumberOfUnits == null ? null : _outstandingNumberOfUnits;
			return this;
		}
		
		@RosettaAttribute("specifiedExercise")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("specifiedExercise")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder addSpecifiedExercise(OptionExerciseAmounts _specifiedExercise) {
			if (_specifiedExercise != null) {
				this.specifiedExercise.add(_specifiedExercise.toBuilder());
			}
			return this;
		}
		
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder addSpecifiedExercise(OptionExerciseAmounts _specifiedExercise, int idx) {
			getIndex(this.specifiedExercise, idx, () -> _specifiedExercise.toBuilder());
			return this;
		}
		
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder addSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercises) {
			if (specifiedExercises != null) {
				for (final OptionExerciseAmounts toAdd : specifiedExercises) {
					this.specifiedExercise.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("specifiedExercise")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("specifiedExercise")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder setSpecifiedExercise(List<? extends OptionExerciseAmounts> specifiedExercises) {
			if (specifiedExercises == null) {
				this.specifiedExercise = new ArrayList<>();
			} else {
				this.specifiedExercise = specifiedExercises.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ActionOnExpiration build() {
			return new ActionOnExpiration.ActionOnExpirationImpl(this);
		}
		
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder prune() {
			if (exerciseInNotionalAmount!=null && !exerciseInNotionalAmount.prune().hasData()) exerciseInNotionalAmount = null;
			if (outstandingNotionalAmount!=null && !outstandingNotionalAmount.prune().hasData()) outstandingNotionalAmount = null;
			specifiedExercise = specifiedExercise.stream().filter(b->b!=null).<OptionExerciseAmounts.OptionExerciseAmountsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseAction()!=null) return true;
			if (getExpiry()!=null) return true;
			if (getFullExercise()!=null) return true;
			if (getExerciseInNotionalAmount()!=null && getExerciseInNotionalAmount().hasData()) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().hasData()) return true;
			if (getExerciseInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			if (getExerciseInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			if (getSpecifiedExercise()!=null && getSpecifiedExercise().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ActionOnExpiration.ActionOnExpirationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ActionOnExpiration.ActionOnExpirationBuilder o = (ActionOnExpiration.ActionOnExpirationBuilder) other;
			
			merger.mergeRosetta(getExerciseInNotionalAmount(), o.getExerciseInNotionalAmount(), this::setExerciseInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::setOutstandingNotionalAmount);
			merger.mergeRosetta(getSpecifiedExercise(), o.getSpecifiedExercise(), this::getOrCreateSpecifiedExercise);
			
			merger.mergeBasic(getExerciseAction(), o.getExerciseAction(), this::setExerciseAction);
			merger.mergeBasic(getExpiry(), o.getExpiry(), this::setExpiry);
			merger.mergeBasic(getFullExercise(), o.getFullExercise(), this::setFullExercise);
			merger.mergeBasic(getExerciseInNumberOfOptions(), o.getExerciseInNumberOfOptions(), this::setExerciseInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			merger.mergeBasic(getExerciseInNumberOfUnits(), o.getExerciseInNumberOfUnits(), this::setExerciseInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ActionOnExpiration _that = getType().cast(o);
		
			if (!Objects.equals(exerciseAction, _that.getExerciseAction())) return false;
			if (!Objects.equals(expiry, _that.getExpiry())) return false;
			if (!Objects.equals(fullExercise, _that.getFullExercise())) return false;
			if (!Objects.equals(exerciseInNotionalAmount, _that.getExerciseInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			if (!Objects.equals(exerciseInNumberOfOptions, _that.getExerciseInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			if (!Objects.equals(exerciseInNumberOfUnits, _that.getExerciseInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			if (!ListEquals.listEquals(specifiedExercise, _that.getSpecifiedExercise())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseAction != null ? exerciseAction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (expiry != null ? expiry.hashCode() : 0);
			_result = 31 * _result + (fullExercise != null ? fullExercise.hashCode() : 0);
			_result = 31 * _result + (exerciseInNotionalAmount != null ? exerciseInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfOptions != null ? exerciseInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (exerciseInNumberOfUnits != null ? exerciseInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (specifiedExercise != null ? specifiedExercise.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ActionOnExpirationBuilder {" +
				"exerciseAction=" + this.exerciseAction + ", " +
				"expiry=" + this.expiry + ", " +
				"fullExercise=" + this.fullExercise + ", " +
				"exerciseInNotionalAmount=" + this.exerciseInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount + ", " +
				"exerciseInNumberOfOptions=" + this.exerciseInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions + ", " +
				"exerciseInNumberOfUnits=" + this.exerciseInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits + ", " +
				"specifiedExercise=" + this.specifiedExercise +
			'}';
		}
	}
}
