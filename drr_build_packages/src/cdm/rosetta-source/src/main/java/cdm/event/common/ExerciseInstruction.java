package cdm.event.common;

import cdm.base.datetime.AdjustableOrAdjustedDate;
import cdm.base.datetime.BusinessCenterTime;
import cdm.event.common.meta.ExerciseInstructionMeta;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the information required to communicate the choices made by the exercising party, in a financial product endowing the party with at least one option.
 * @version 6.23.0
 */
@RosettaDataType(value="ExerciseInstruction", builder=ExerciseInstruction.ExerciseInstructionBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ExerciseInstruction", model="cdm", builder=ExerciseInstruction.ExerciseInstructionBuilderImpl.class, version="6.23.0")
public interface ExerciseInstruction extends RosettaModelObject {

	ExerciseInstructionMeta metaData = new ExerciseInstructionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Contains instructions for exercising the option including a quantity change, and optionally a transfer.
	 */
	PrimitiveInstruction getExerciseQuantity();
	/**
	 * Specifies the Option Payout being exercised on the trade.
	 */
	ReferenceWithMetaPayout getExerciseOption();
	/**
	 * Specifies the date on which an option contained within the financial product would be exercised. The date may be omitted if the contractual product allows for only a single date of exercise (European exercise).
	 */
	AdjustableOrAdjustedDate getExerciseDate();
	/**
	 * Specifies the time at which an option contained within the financial product woulld be exercised. The time may be omitted if the contractual product allows for only a single time of exercise (European exercise). 
	 */
	BusinessCenterTime getExerciseTime();
	/**
	 * Specifies the trade identifier to apply to the replacement trade for physical exercise.
	 */
	List<? extends TradeIdentifier> getReplacementTradeIdentifier();

	/*********************** Build Methods  ***********************/
	ExerciseInstruction build();
	
	ExerciseInstruction.ExerciseInstructionBuilder toBuilder();
	
	static ExerciseInstruction.ExerciseInstructionBuilder builder() {
		return new ExerciseInstruction.ExerciseInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ExerciseInstruction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ExerciseInstruction> getType() {
		return ExerciseInstruction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("exerciseQuantity"), processor, PrimitiveInstruction.class, getExerciseQuantity());
		processRosetta(path.newSubPath("exerciseOption"), processor, ReferenceWithMetaPayout.class, getExerciseOption());
		processRosetta(path.newSubPath("exerciseDate"), processor, AdjustableOrAdjustedDate.class, getExerciseDate());
		processRosetta(path.newSubPath("exerciseTime"), processor, BusinessCenterTime.class, getExerciseTime());
		processRosetta(path.newSubPath("replacementTradeIdentifier"), processor, TradeIdentifier.class, getReplacementTradeIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ExerciseInstructionBuilder extends ExerciseInstruction, RosettaModelObjectBuilder {
		PrimitiveInstruction.PrimitiveInstructionBuilder getOrCreateExerciseQuantity();
		@Override
		PrimitiveInstruction.PrimitiveInstructionBuilder getExerciseQuantity();
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getOrCreateExerciseOption();
		@Override
		ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getExerciseOption();
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateExerciseDate();
		@Override
		AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getExerciseDate();
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExerciseTime();
		@Override
		BusinessCenterTime.BusinessCenterTimeBuilder getExerciseTime();
		TradeIdentifier.TradeIdentifierBuilder getOrCreateReplacementTradeIdentifier(int index);
		@Override
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getReplacementTradeIdentifier();
		ExerciseInstruction.ExerciseInstructionBuilder setExerciseQuantity(PrimitiveInstruction exerciseQuantity);
		ExerciseInstruction.ExerciseInstructionBuilder setExerciseOption(ReferenceWithMetaPayout exerciseOption);
		ExerciseInstruction.ExerciseInstructionBuilder setExerciseOptionValue(Payout exerciseOption);
		ExerciseInstruction.ExerciseInstructionBuilder setExerciseDate(AdjustableOrAdjustedDate exerciseDate);
		ExerciseInstruction.ExerciseInstructionBuilder setExerciseTime(BusinessCenterTime exerciseTime);
		ExerciseInstruction.ExerciseInstructionBuilder addReplacementTradeIdentifier(TradeIdentifier replacementTradeIdentifier);
		ExerciseInstruction.ExerciseInstructionBuilder addReplacementTradeIdentifier(TradeIdentifier replacementTradeIdentifier, int idx);
		ExerciseInstruction.ExerciseInstructionBuilder addReplacementTradeIdentifier(List<? extends TradeIdentifier> replacementTradeIdentifier);
		ExerciseInstruction.ExerciseInstructionBuilder setReplacementTradeIdentifier(List<? extends TradeIdentifier> replacementTradeIdentifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("exerciseQuantity"), processor, PrimitiveInstruction.PrimitiveInstructionBuilder.class, getExerciseQuantity());
			processRosetta(path.newSubPath("exerciseOption"), processor, ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder.class, getExerciseOption());
			processRosetta(path.newSubPath("exerciseDate"), processor, AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder.class, getExerciseDate());
			processRosetta(path.newSubPath("exerciseTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getExerciseTime());
			processRosetta(path.newSubPath("replacementTradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getReplacementTradeIdentifier());
		}
		

		ExerciseInstruction.ExerciseInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of ExerciseInstruction  ***********************/
	class ExerciseInstructionImpl implements ExerciseInstruction {
		private final PrimitiveInstruction exerciseQuantity;
		private final ReferenceWithMetaPayout exerciseOption;
		private final AdjustableOrAdjustedDate exerciseDate;
		private final BusinessCenterTime exerciseTime;
		private final List<? extends TradeIdentifier> replacementTradeIdentifier;
		
		protected ExerciseInstructionImpl(ExerciseInstruction.ExerciseInstructionBuilder builder) {
			this.exerciseQuantity = ofNullable(builder.getExerciseQuantity()).map(f->f.build()).orElse(null);
			this.exerciseOption = ofNullable(builder.getExerciseOption()).map(f->f.build()).orElse(null);
			this.exerciseDate = ofNullable(builder.getExerciseDate()).map(f->f.build()).orElse(null);
			this.exerciseTime = ofNullable(builder.getExerciseTime()).map(f->f.build()).orElse(null);
			this.replacementTradeIdentifier = ofNullable(builder.getReplacementTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("exerciseQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exerciseQuantity")
		public PrimitiveInstruction getExerciseQuantity() {
			return exerciseQuantity;
		}
		
		@Override
		@RosettaAttribute("exerciseOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseOption")
		public ReferenceWithMetaPayout getExerciseOption() {
			return exerciseOption;
		}
		
		@Override
		@RosettaAttribute("exerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseDate")
		public AdjustableOrAdjustedDate getExerciseDate() {
			return exerciseDate;
		}
		
		@Override
		@RosettaAttribute("exerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseTime")
		public BusinessCenterTime getExerciseTime() {
			return exerciseTime;
		}
		
		@Override
		@RosettaAttribute("replacementTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("replacementTradeIdentifier")
		public List<? extends TradeIdentifier> getReplacementTradeIdentifier() {
			return replacementTradeIdentifier;
		}
		
		@Override
		public ExerciseInstruction build() {
			return this;
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder toBuilder() {
			ExerciseInstruction.ExerciseInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExerciseInstruction.ExerciseInstructionBuilder builder) {
			ofNullable(getExerciseQuantity()).ifPresent(builder::setExerciseQuantity);
			ofNullable(getExerciseOption()).ifPresent(builder::setExerciseOption);
			ofNullable(getExerciseDate()).ifPresent(builder::setExerciseDate);
			ofNullable(getExerciseTime()).ifPresent(builder::setExerciseTime);
			ofNullable(getReplacementTradeIdentifier()).ifPresent(builder::setReplacementTradeIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseInstruction _that = getType().cast(o);
		
			if (!Objects.equals(exerciseQuantity, _that.getExerciseQuantity())) return false;
			if (!Objects.equals(exerciseOption, _that.getExerciseOption())) return false;
			if (!Objects.equals(exerciseDate, _that.getExerciseDate())) return false;
			if (!Objects.equals(exerciseTime, _that.getExerciseTime())) return false;
			if (!ListEquals.listEquals(replacementTradeIdentifier, _that.getReplacementTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseQuantity != null ? exerciseQuantity.hashCode() : 0);
			_result = 31 * _result + (exerciseOption != null ? exerciseOption.hashCode() : 0);
			_result = 31 * _result + (exerciseDate != null ? exerciseDate.hashCode() : 0);
			_result = 31 * _result + (exerciseTime != null ? exerciseTime.hashCode() : 0);
			_result = 31 * _result + (replacementTradeIdentifier != null ? replacementTradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseInstruction {" +
				"exerciseQuantity=" + this.exerciseQuantity + ", " +
				"exerciseOption=" + this.exerciseOption + ", " +
				"exerciseDate=" + this.exerciseDate + ", " +
				"exerciseTime=" + this.exerciseTime + ", " +
				"replacementTradeIdentifier=" + this.replacementTradeIdentifier +
			'}';
		}
	}

	/*********************** Builder Implementation of ExerciseInstruction  ***********************/
	class ExerciseInstructionBuilderImpl implements ExerciseInstruction.ExerciseInstructionBuilder {
	
		protected PrimitiveInstruction.PrimitiveInstructionBuilder exerciseQuantity;
		protected ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder exerciseOption;
		protected AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder exerciseDate;
		protected BusinessCenterTime.BusinessCenterTimeBuilder exerciseTime;
		protected List<TradeIdentifier.TradeIdentifierBuilder> replacementTradeIdentifier = new ArrayList<>();
		
		@Override
		@RosettaAttribute("exerciseQuantity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exerciseQuantity")
		public PrimitiveInstruction.PrimitiveInstructionBuilder getExerciseQuantity() {
			return exerciseQuantity;
		}
		
		@Override
		public PrimitiveInstruction.PrimitiveInstructionBuilder getOrCreateExerciseQuantity() {
			PrimitiveInstruction.PrimitiveInstructionBuilder result;
			if (exerciseQuantity!=null) {
				result = exerciseQuantity;
			}
			else {
				result = exerciseQuantity = PrimitiveInstruction.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseOption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseOption")
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getExerciseOption() {
			return exerciseOption;
		}
		
		@Override
		public ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder getOrCreateExerciseOption() {
			ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder result;
			if (exerciseOption!=null) {
				result = exerciseOption;
			}
			else {
				result = exerciseOption = ReferenceWithMetaPayout.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseDate")
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getExerciseDate() {
			return exerciseDate;
		}
		
		@Override
		public AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder getOrCreateExerciseDate() {
			AdjustableOrAdjustedDate.AdjustableOrAdjustedDateBuilder result;
			if (exerciseDate!=null) {
				result = exerciseDate;
			}
			else {
				result = exerciseDate = AdjustableOrAdjustedDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exerciseTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseTime")
		public BusinessCenterTime.BusinessCenterTimeBuilder getExerciseTime() {
			return exerciseTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateExerciseTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (exerciseTime!=null) {
				result = exerciseTime;
			}
			else {
				result = exerciseTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("replacementTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("replacementTradeIdentifier")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getReplacementTradeIdentifier() {
			return replacementTradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateReplacementTradeIdentifier(int index) {
			if (replacementTradeIdentifier==null) {
				this.replacementTradeIdentifier = new ArrayList<>();
			}
			return getIndex(replacementTradeIdentifier, index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newReplacementTradeIdentifier = TradeIdentifier.builder();
						return newReplacementTradeIdentifier;
					});
		}
		
		@RosettaAttribute("exerciseQuantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exerciseQuantity")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder setExerciseQuantity(PrimitiveInstruction _exerciseQuantity) {
			this.exerciseQuantity = _exerciseQuantity == null ? null : _exerciseQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseOption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseOption")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder setExerciseOption(ReferenceWithMetaPayout _exerciseOption) {
			this.exerciseOption = _exerciseOption == null ? null : _exerciseOption.toBuilder();
			return this;
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder setExerciseOptionValue(Payout _exerciseOption) {
			this.getOrCreateExerciseOption().setValue(_exerciseOption);
			return this;
		}
		
		@RosettaAttribute("exerciseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseDate")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder setExerciseDate(AdjustableOrAdjustedDate _exerciseDate) {
			this.exerciseDate = _exerciseDate == null ? null : _exerciseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exerciseTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseTime")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder setExerciseTime(BusinessCenterTime _exerciseTime) {
			this.exerciseTime = _exerciseTime == null ? null : _exerciseTime.toBuilder();
			return this;
		}
		
		@RosettaAttribute("replacementTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("replacementTradeIdentifier")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder addReplacementTradeIdentifier(TradeIdentifier _replacementTradeIdentifier) {
			if (_replacementTradeIdentifier != null) {
				this.replacementTradeIdentifier.add(_replacementTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder addReplacementTradeIdentifier(TradeIdentifier _replacementTradeIdentifier, int idx) {
			getIndex(this.replacementTradeIdentifier, idx, () -> _replacementTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder addReplacementTradeIdentifier(List<? extends TradeIdentifier> replacementTradeIdentifiers) {
			if (replacementTradeIdentifiers != null) {
				for (final TradeIdentifier toAdd : replacementTradeIdentifiers) {
					this.replacementTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("replacementTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("replacementTradeIdentifier")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder setReplacementTradeIdentifier(List<? extends TradeIdentifier> replacementTradeIdentifiers) {
			if (replacementTradeIdentifiers == null) {
				this.replacementTradeIdentifier = new ArrayList<>();
			} else {
				this.replacementTradeIdentifier = replacementTradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ExerciseInstruction build() {
			return new ExerciseInstruction.ExerciseInstructionImpl(this);
		}
		
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder prune() {
			if (exerciseQuantity!=null && !exerciseQuantity.prune().hasData()) exerciseQuantity = null;
			if (exerciseOption!=null && !exerciseOption.prune().hasData()) exerciseOption = null;
			if (exerciseDate!=null && !exerciseDate.prune().hasData()) exerciseDate = null;
			if (exerciseTime!=null && !exerciseTime.prune().hasData()) exerciseTime = null;
			replacementTradeIdentifier = replacementTradeIdentifier.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExerciseQuantity()!=null && getExerciseQuantity().hasData()) return true;
			if (getExerciseOption()!=null && getExerciseOption().hasData()) return true;
			if (getExerciseDate()!=null && getExerciseDate().hasData()) return true;
			if (getExerciseTime()!=null && getExerciseTime().hasData()) return true;
			if (getReplacementTradeIdentifier()!=null && getReplacementTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExerciseInstruction.ExerciseInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExerciseInstruction.ExerciseInstructionBuilder o = (ExerciseInstruction.ExerciseInstructionBuilder) other;
			
			merger.mergeRosetta(getExerciseQuantity(), o.getExerciseQuantity(), this::setExerciseQuantity);
			merger.mergeRosetta(getExerciseOption(), o.getExerciseOption(), this::setExerciseOption);
			merger.mergeRosetta(getExerciseDate(), o.getExerciseDate(), this::setExerciseDate);
			merger.mergeRosetta(getExerciseTime(), o.getExerciseTime(), this::setExerciseTime);
			merger.mergeRosetta(getReplacementTradeIdentifier(), o.getReplacementTradeIdentifier(), this::getOrCreateReplacementTradeIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExerciseInstruction _that = getType().cast(o);
		
			if (!Objects.equals(exerciseQuantity, _that.getExerciseQuantity())) return false;
			if (!Objects.equals(exerciseOption, _that.getExerciseOption())) return false;
			if (!Objects.equals(exerciseDate, _that.getExerciseDate())) return false;
			if (!Objects.equals(exerciseTime, _that.getExerciseTime())) return false;
			if (!ListEquals.listEquals(replacementTradeIdentifier, _that.getReplacementTradeIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exerciseQuantity != null ? exerciseQuantity.hashCode() : 0);
			_result = 31 * _result + (exerciseOption != null ? exerciseOption.hashCode() : 0);
			_result = 31 * _result + (exerciseDate != null ? exerciseDate.hashCode() : 0);
			_result = 31 * _result + (exerciseTime != null ? exerciseTime.hashCode() : 0);
			_result = 31 * _result + (replacementTradeIdentifier != null ? replacementTradeIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExerciseInstructionBuilder {" +
				"exerciseQuantity=" + this.exerciseQuantity + ", " +
				"exerciseOption=" + this.exerciseOption + ", " +
				"exerciseDate=" + this.exerciseDate + ", " +
				"exerciseTime=" + this.exerciseTime + ", " +
				"replacementTradeIdentifier=" + this.replacementTradeIdentifier +
			'}';
		}
	}
}
