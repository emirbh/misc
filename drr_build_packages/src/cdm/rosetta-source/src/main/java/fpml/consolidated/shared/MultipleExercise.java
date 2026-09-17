package fpml.consolidated.shared;

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
import fpml.consolidated.shared.meta.MultipleExerciseMeta;
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
 * Provision A type defining multiple exercises. As defining in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more than the maximum notional amount, and if an integral multiple amount is specified, the notional exercised must be equal to or, be an integral multiple of, the integral multiple amount.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining multiple exercises. As defining in the 2000 ISDA Definitions, Section 12.4. Multiple Exercise, the buyer of the option has the right to exercise all or less than all the unexercised notional amount of the underlying swap on one or more days in the exercise period, but on any such day may not exercise less than the minimum notional amount or more than the maximum notional amount, and if an integral multiple amount is specified, the notional exercised must be equal to or, be an integral multiple of, the integral multiple amount.
 *
 */
@RosettaDataType(value="MultipleExercise", builder=MultipleExercise.MultipleExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MultipleExercise", model="fpml", builder=MultipleExercise.MultipleExerciseBuilderImpl.class, version="2.1.1")
public interface MultipleExercise extends RosettaModelObject {

	MultipleExerciseMeta metaData = new MultipleExerciseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the associated notional schedule defined elsewhere in the document. This element has been made optional as part of its integration in the OptionBaseExtended, because not required for the options on securities.
	 *
	 */
	List<? extends NotionalReference> getNotionalReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A notional amount which restricts the amount of notional that can be exercised when partial exercise or multiple exercise is applicable. The integral multiple amount defines a lower limit of notional that can be exercised and also defines a unit multiple of notional that can be exercised, i.e. only integer multiples of this amount can be exercised.
	 *
	 */
	BigDecimal getIntegralMultipleAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The minimum notional amount that can be exercised on a given exercise date. See multipleExercise.
	 *
	 */
	BigDecimal getMinimumNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The minimum number of options that can be exercised on a given exercise date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The minimum number of options that can be exercised on a given exercise date.
	 *
	 */
	BigDecimal getMinimumNumberOfOptions();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum notional amount that can be exercised on a given exercise date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum notional amount that can be exercised on a given exercise date.
	 *
	 */
	BigDecimal getMaximumNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The maximum number of options that can be exercised on a given exercise date. If the number is not specified, it means that the maximum number of options corresponds to the remaining unexercised options.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The maximum number of options that can be exercised on a given exercise date. If the number is not specified, it means that the maximum number of options corresponds to the remaining unexercised options.
	 *
	 */
	BigDecimal getMaximumNumberOfOptions();

	/*********************** Build Methods  ***********************/
	MultipleExercise build();
	
	MultipleExercise.MultipleExerciseBuilder toBuilder();
	
	static MultipleExercise.MultipleExerciseBuilder builder() {
		return new MultipleExercise.MultipleExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MultipleExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MultipleExercise> getType() {
		return MultipleExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
		processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
		processor.processBasic(path.newSubPath("minimumNumberOfOptions"), BigDecimal.class, getMinimumNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("maximumNotionalAmount"), BigDecimal.class, getMaximumNotionalAmount(), this);
		processor.processBasic(path.newSubPath("maximumNumberOfOptions"), BigDecimal.class, getMaximumNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MultipleExerciseBuilder extends MultipleExercise, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference(int index);
		@Override
		List<? extends NotionalReference.NotionalReferenceBuilder> getNotionalReference();
		MultipleExercise.MultipleExerciseBuilder addNotionalReference(NotionalReference notionalReference);
		MultipleExercise.MultipleExerciseBuilder addNotionalReference(NotionalReference notionalReference, int idx);
		MultipleExercise.MultipleExerciseBuilder addNotionalReference(List<? extends NotionalReference> notionalReference);
		MultipleExercise.MultipleExerciseBuilder setNotionalReference(List<? extends NotionalReference> notionalReference);
		MultipleExercise.MultipleExerciseBuilder setIntegralMultipleAmount(BigDecimal integralMultipleAmount);
		MultipleExercise.MultipleExerciseBuilder setMinimumNotionalAmount(BigDecimal minimumNotionalAmount);
		MultipleExercise.MultipleExerciseBuilder setMinimumNumberOfOptions(BigDecimal minimumNumberOfOptions);
		MultipleExercise.MultipleExerciseBuilder setMaximumNotionalAmount(BigDecimal maximumNotionalAmount);
		MultipleExercise.MultipleExerciseBuilder setMaximumNumberOfOptions(BigDecimal maximumNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
			processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
			processor.processBasic(path.newSubPath("minimumNumberOfOptions"), BigDecimal.class, getMinimumNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("maximumNotionalAmount"), BigDecimal.class, getMaximumNotionalAmount(), this);
			processor.processBasic(path.newSubPath("maximumNumberOfOptions"), BigDecimal.class, getMaximumNumberOfOptions(), this);
		}
		

		MultipleExercise.MultipleExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of MultipleExercise  ***********************/
	class MultipleExerciseImpl implements MultipleExercise {
		private final List<? extends NotionalReference> notionalReference;
		private final BigDecimal integralMultipleAmount;
		private final BigDecimal minimumNotionalAmount;
		private final BigDecimal minimumNumberOfOptions;
		private final BigDecimal maximumNotionalAmount;
		private final BigDecimal maximumNumberOfOptions;
		
		protected MultipleExerciseImpl(MultipleExercise.MultipleExerciseBuilder builder) {
			this.notionalReference = ofNullable(builder.getNotionalReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.integralMultipleAmount = builder.getIntegralMultipleAmount();
			this.minimumNotionalAmount = builder.getMinimumNotionalAmount();
			this.minimumNumberOfOptions = builder.getMinimumNumberOfOptions();
			this.maximumNotionalAmount = builder.getMaximumNotionalAmount();
			this.maximumNumberOfOptions = builder.getMaximumNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalReference")
		public List<? extends NotionalReference> getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("integralMultipleAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("integralMultipleAmount")
		public BigDecimal getIntegralMultipleAmount() {
			return integralMultipleAmount;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNotionalAmount")
		public BigDecimal getMinimumNotionalAmount() {
			return minimumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("minimumNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNumberOfOptions")
		public BigDecimal getMinimumNumberOfOptions() {
			return minimumNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNotionalAmount")
		public BigDecimal getMaximumNotionalAmount() {
			return maximumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNumberOfOptions")
		public BigDecimal getMaximumNumberOfOptions() {
			return maximumNumberOfOptions;
		}
		
		@Override
		public MultipleExercise build() {
			return this;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder toBuilder() {
			MultipleExercise.MultipleExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MultipleExercise.MultipleExerciseBuilder builder) {
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getIntegralMultipleAmount()).ifPresent(builder::setIntegralMultipleAmount);
			ofNullable(getMinimumNotionalAmount()).ifPresent(builder::setMinimumNotionalAmount);
			ofNullable(getMinimumNumberOfOptions()).ifPresent(builder::setMinimumNumberOfOptions);
			ofNullable(getMaximumNotionalAmount()).ifPresent(builder::setMaximumNotionalAmount);
			ofNullable(getMaximumNumberOfOptions()).ifPresent(builder::setMaximumNumberOfOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultipleExercise _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(integralMultipleAmount, _that.getIntegralMultipleAmount())) return false;
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			if (!Objects.equals(maximumNotionalAmount, _that.getMaximumNotionalAmount())) return false;
			if (!Objects.equals(maximumNumberOfOptions, _that.getMaximumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (integralMultipleAmount != null ? integralMultipleAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (maximumNotionalAmount != null ? maximumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfOptions != null ? maximumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleExercise {" +
				"notionalReference=" + this.notionalReference + ", " +
				"integralMultipleAmount=" + this.integralMultipleAmount + ", " +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions + ", " +
				"maximumNotionalAmount=" + this.maximumNotionalAmount + ", " +
				"maximumNumberOfOptions=" + this.maximumNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of MultipleExercise  ***********************/
	class MultipleExerciseBuilderImpl implements MultipleExercise.MultipleExerciseBuilder {
	
		protected List<NotionalReference.NotionalReferenceBuilder> notionalReference = new ArrayList<>();
		protected BigDecimal integralMultipleAmount;
		protected BigDecimal minimumNotionalAmount;
		protected BigDecimal minimumNumberOfOptions;
		protected BigDecimal maximumNotionalAmount;
		protected BigDecimal maximumNumberOfOptions;
		
		@Override
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("notionalReference")
		public List<? extends NotionalReference.NotionalReferenceBuilder> getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference(int index) {
			if (notionalReference==null) {
				this.notionalReference = new ArrayList<>();
			}
			return getIndex(notionalReference, index, () -> {
						NotionalReference.NotionalReferenceBuilder newNotionalReference = NotionalReference.builder();
						return newNotionalReference;
					});
		}
		
		@Override
		@RosettaAttribute("integralMultipleAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("integralMultipleAmount")
		public BigDecimal getIntegralMultipleAmount() {
			return integralMultipleAmount;
		}
		
		@Override
		@RosettaAttribute("minimumNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNotionalAmount")
		public BigDecimal getMinimumNotionalAmount() {
			return minimumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("minimumNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("minimumNumberOfOptions")
		public BigDecimal getMinimumNumberOfOptions() {
			return minimumNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("maximumNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNotionalAmount")
		public BigDecimal getMaximumNotionalAmount() {
			return maximumNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("maximumNumberOfOptions")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("maximumNumberOfOptions")
		public BigDecimal getMaximumNumberOfOptions() {
			return maximumNumberOfOptions;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalReference")
		@Override
		public MultipleExercise.MultipleExerciseBuilder addNotionalReference(NotionalReference _notionalReference) {
			if (_notionalReference != null) {
				this.notionalReference.add(_notionalReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder addNotionalReference(NotionalReference _notionalReference, int idx) {
			getIndex(this.notionalReference, idx, () -> _notionalReference.toBuilder());
			return this;
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder addNotionalReference(List<? extends NotionalReference> notionalReferences) {
			if (notionalReferences != null) {
				for (final NotionalReference toAdd : notionalReferences) {
					this.notionalReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("notionalReference")
		@Override
		public MultipleExercise.MultipleExerciseBuilder setNotionalReference(List<? extends NotionalReference> notionalReferences) {
			if (notionalReferences == null) {
				this.notionalReference = new ArrayList<>();
			} else {
				this.notionalReference = notionalReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("integralMultipleAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("integralMultipleAmount")
		@Override
		public MultipleExercise.MultipleExerciseBuilder setIntegralMultipleAmount(BigDecimal _integralMultipleAmount) {
			this.integralMultipleAmount = _integralMultipleAmount == null ? null : _integralMultipleAmount;
			return this;
		}
		
		@RosettaAttribute("minimumNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumNotionalAmount")
		@Override
		public MultipleExercise.MultipleExerciseBuilder setMinimumNotionalAmount(BigDecimal _minimumNotionalAmount) {
			this.minimumNotionalAmount = _minimumNotionalAmount == null ? null : _minimumNotionalAmount;
			return this;
		}
		
		@RosettaAttribute("minimumNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumNumberOfOptions")
		@Override
		public MultipleExercise.MultipleExerciseBuilder setMinimumNumberOfOptions(BigDecimal _minimumNumberOfOptions) {
			this.minimumNumberOfOptions = _minimumNumberOfOptions == null ? null : _minimumNumberOfOptions;
			return this;
		}
		
		@RosettaAttribute("maximumNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumNotionalAmount")
		@Override
		public MultipleExercise.MultipleExerciseBuilder setMaximumNotionalAmount(BigDecimal _maximumNotionalAmount) {
			this.maximumNotionalAmount = _maximumNotionalAmount == null ? null : _maximumNotionalAmount;
			return this;
		}
		
		@RosettaAttribute("maximumNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("maximumNumberOfOptions")
		@Override
		public MultipleExercise.MultipleExerciseBuilder setMaximumNumberOfOptions(BigDecimal _maximumNumberOfOptions) {
			this.maximumNumberOfOptions = _maximumNumberOfOptions == null ? null : _maximumNumberOfOptions;
			return this;
		}
		
		@Override
		public MultipleExercise build() {
			return new MultipleExercise.MultipleExerciseImpl(this);
		}
		
		@Override
		public MultipleExercise.MultipleExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleExercise.MultipleExerciseBuilder prune() {
			notionalReference = notionalReference.stream().filter(b->b!=null).<NotionalReference.NotionalReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalReference()!=null && getNotionalReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIntegralMultipleAmount()!=null) return true;
			if (getMinimumNotionalAmount()!=null) return true;
			if (getMinimumNumberOfOptions()!=null) return true;
			if (getMaximumNotionalAmount()!=null) return true;
			if (getMaximumNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MultipleExercise.MultipleExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MultipleExercise.MultipleExerciseBuilder o = (MultipleExercise.MultipleExerciseBuilder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::getOrCreateNotionalReference);
			
			merger.mergeBasic(getIntegralMultipleAmount(), o.getIntegralMultipleAmount(), this::setIntegralMultipleAmount);
			merger.mergeBasic(getMinimumNotionalAmount(), o.getMinimumNotionalAmount(), this::setMinimumNotionalAmount);
			merger.mergeBasic(getMinimumNumberOfOptions(), o.getMinimumNumberOfOptions(), this::setMinimumNumberOfOptions);
			merger.mergeBasic(getMaximumNotionalAmount(), o.getMaximumNotionalAmount(), this::setMaximumNotionalAmount);
			merger.mergeBasic(getMaximumNumberOfOptions(), o.getMaximumNumberOfOptions(), this::setMaximumNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MultipleExercise _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(integralMultipleAmount, _that.getIntegralMultipleAmount())) return false;
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			if (!Objects.equals(maximumNotionalAmount, _that.getMaximumNotionalAmount())) return false;
			if (!Objects.equals(maximumNumberOfOptions, _that.getMaximumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (integralMultipleAmount != null ? integralMultipleAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (maximumNotionalAmount != null ? maximumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (maximumNumberOfOptions != null ? maximumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MultipleExerciseBuilder {" +
				"notionalReference=" + this.notionalReference + ", " +
				"integralMultipleAmount=" + this.integralMultipleAmount + ", " +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions + ", " +
				"maximumNotionalAmount=" + this.maximumNotionalAmount + ", " +
				"maximumNumberOfOptions=" + this.maximumNumberOfOptions +
			'}';
		}
	}
}
