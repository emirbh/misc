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
import fpml.consolidated.shared.meta.PartialExerciseMeta;
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
 * Provision A type defining partial exercise. As defined in the 2000 ISDA Definitions, Section 12.3 Partial Exercise, the buyer of the option may exercise all or less than all the notional amount of the underlying swap but may not be less than the minimum notional amount (if specified) and must be an integral multiple of the integral multiple amount if specified.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining partial exercise. As defined in the 2000 ISDA Definitions, Section 12.3 Partial Exercise, the buyer of the option may exercise all or less than all the notional amount of the underlying swap but may not be less than the minimum notional amount (if specified) and must be an integral multiple of the integral multiple amount if specified.
 *
 */
@RosettaDataType(value="PartialExercise", builder=PartialExercise.PartialExerciseBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PartialExercise", model="fpml", builder=PartialExercise.PartialExerciseBuilderImpl.class, version="2.1.1")
public interface PartialExercise extends RosettaModelObject {

	PartialExerciseMeta metaData = new PartialExerciseMeta();

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

	/*********************** Build Methods  ***********************/
	PartialExercise build();
	
	PartialExercise.PartialExerciseBuilder toBuilder();
	
	static PartialExercise.PartialExerciseBuilder builder() {
		return new PartialExercise.PartialExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartialExercise> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PartialExercise> getType() {
		return PartialExercise.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
		processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
		processor.processBasic(path.newSubPath("minimumNumberOfOptions"), BigDecimal.class, getMinimumNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartialExerciseBuilder extends PartialExercise, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference(int index);
		@Override
		List<? extends NotionalReference.NotionalReferenceBuilder> getNotionalReference();
		PartialExercise.PartialExerciseBuilder addNotionalReference(NotionalReference notionalReference);
		PartialExercise.PartialExerciseBuilder addNotionalReference(NotionalReference notionalReference, int idx);
		PartialExercise.PartialExerciseBuilder addNotionalReference(List<? extends NotionalReference> notionalReference);
		PartialExercise.PartialExerciseBuilder setNotionalReference(List<? extends NotionalReference> notionalReference);
		PartialExercise.PartialExerciseBuilder setIntegralMultipleAmount(BigDecimal integralMultipleAmount);
		PartialExercise.PartialExerciseBuilder setMinimumNotionalAmount(BigDecimal minimumNotionalAmount);
		PartialExercise.PartialExerciseBuilder setMinimumNumberOfOptions(BigDecimal minimumNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processor.processBasic(path.newSubPath("integralMultipleAmount"), BigDecimal.class, getIntegralMultipleAmount(), this);
			processor.processBasic(path.newSubPath("minimumNotionalAmount"), BigDecimal.class, getMinimumNotionalAmount(), this);
			processor.processBasic(path.newSubPath("minimumNumberOfOptions"), BigDecimal.class, getMinimumNumberOfOptions(), this);
		}
		

		PartialExercise.PartialExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of PartialExercise  ***********************/
	class PartialExerciseImpl implements PartialExercise {
		private final List<? extends NotionalReference> notionalReference;
		private final BigDecimal integralMultipleAmount;
		private final BigDecimal minimumNotionalAmount;
		private final BigDecimal minimumNumberOfOptions;
		
		protected PartialExerciseImpl(PartialExercise.PartialExerciseBuilder builder) {
			this.notionalReference = ofNullable(builder.getNotionalReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.integralMultipleAmount = builder.getIntegralMultipleAmount();
			this.minimumNotionalAmount = builder.getMinimumNotionalAmount();
			this.minimumNumberOfOptions = builder.getMinimumNumberOfOptions();
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
		public PartialExercise build() {
			return this;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder toBuilder() {
			PartialExercise.PartialExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartialExercise.PartialExerciseBuilder builder) {
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getIntegralMultipleAmount()).ifPresent(builder::setIntegralMultipleAmount);
			ofNullable(getMinimumNotionalAmount()).ifPresent(builder::setMinimumNotionalAmount);
			ofNullable(getMinimumNumberOfOptions()).ifPresent(builder::setMinimumNumberOfOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartialExercise _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(integralMultipleAmount, _that.getIntegralMultipleAmount())) return false;
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (integralMultipleAmount != null ? integralMultipleAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartialExercise {" +
				"notionalReference=" + this.notionalReference + ", " +
				"integralMultipleAmount=" + this.integralMultipleAmount + ", " +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of PartialExercise  ***********************/
	class PartialExerciseBuilderImpl implements PartialExercise.PartialExerciseBuilder {
	
		protected List<NotionalReference.NotionalReferenceBuilder> notionalReference = new ArrayList<>();
		protected BigDecimal integralMultipleAmount;
		protected BigDecimal minimumNotionalAmount;
		protected BigDecimal minimumNumberOfOptions;
		
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
		
		@RosettaAttribute("notionalReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("notionalReference")
		@Override
		public PartialExercise.PartialExerciseBuilder addNotionalReference(NotionalReference _notionalReference) {
			if (_notionalReference != null) {
				this.notionalReference.add(_notionalReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder addNotionalReference(NotionalReference _notionalReference, int idx) {
			getIndex(this.notionalReference, idx, () -> _notionalReference.toBuilder());
			return this;
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder addNotionalReference(List<? extends NotionalReference> notionalReferences) {
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
		public PartialExercise.PartialExerciseBuilder setNotionalReference(List<? extends NotionalReference> notionalReferences) {
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
		public PartialExercise.PartialExerciseBuilder setIntegralMultipleAmount(BigDecimal _integralMultipleAmount) {
			this.integralMultipleAmount = _integralMultipleAmount == null ? null : _integralMultipleAmount;
			return this;
		}
		
		@RosettaAttribute("minimumNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumNotionalAmount")
		@Override
		public PartialExercise.PartialExerciseBuilder setMinimumNotionalAmount(BigDecimal _minimumNotionalAmount) {
			this.minimumNotionalAmount = _minimumNotionalAmount == null ? null : _minimumNotionalAmount;
			return this;
		}
		
		@RosettaAttribute("minimumNumberOfOptions")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("minimumNumberOfOptions")
		@Override
		public PartialExercise.PartialExerciseBuilder setMinimumNumberOfOptions(BigDecimal _minimumNumberOfOptions) {
			this.minimumNumberOfOptions = _minimumNumberOfOptions == null ? null : _minimumNumberOfOptions;
			return this;
		}
		
		@Override
		public PartialExercise build() {
			return new PartialExercise.PartialExerciseImpl(this);
		}
		
		@Override
		public PartialExercise.PartialExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartialExercise.PartialExerciseBuilder prune() {
			notionalReference = notionalReference.stream().filter(b->b!=null).<NotionalReference.NotionalReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalReference()!=null && getNotionalReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getIntegralMultipleAmount()!=null) return true;
			if (getMinimumNotionalAmount()!=null) return true;
			if (getMinimumNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartialExercise.PartialExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartialExercise.PartialExerciseBuilder o = (PartialExercise.PartialExerciseBuilder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::getOrCreateNotionalReference);
			
			merger.mergeBasic(getIntegralMultipleAmount(), o.getIntegralMultipleAmount(), this::setIntegralMultipleAmount);
			merger.mergeBasic(getMinimumNotionalAmount(), o.getMinimumNotionalAmount(), this::setMinimumNotionalAmount);
			merger.mergeBasic(getMinimumNumberOfOptions(), o.getMinimumNumberOfOptions(), this::setMinimumNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartialExercise _that = getType().cast(o);
		
			if (!ListEquals.listEquals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(integralMultipleAmount, _that.getIntegralMultipleAmount())) return false;
			if (!Objects.equals(minimumNotionalAmount, _that.getMinimumNotionalAmount())) return false;
			if (!Objects.equals(minimumNumberOfOptions, _that.getMinimumNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (integralMultipleAmount != null ? integralMultipleAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNotionalAmount != null ? minimumNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (minimumNumberOfOptions != null ? minimumNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartialExerciseBuilder {" +
				"notionalReference=" + this.notionalReference + ", " +
				"integralMultipleAmount=" + this.integralMultipleAmount + ", " +
				"minimumNotionalAmount=" + this.minimumNotionalAmount + ", " +
				"minimumNumberOfOptions=" + this.minimumNumberOfOptions +
			'}';
		}
	}
}
