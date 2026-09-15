package fpml.consolidated.riskdef;

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
import fpml.consolidated.riskdef.meta.FormulaTermMeta;
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
 * Provision A type defining a term of the formula. Its value is the product of the its coefficient and the referenced partial derivatives.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a term of the formula. Its value is the product of the its coefficient and the referenced partial derivatives.
 *
 */
@RosettaDataType(value="FormulaTerm", builder=FormulaTerm.FormulaTermBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FormulaTerm", model="fpml", builder=FormulaTerm.FormulaTermBuilderImpl.class, version="2.1.1")
public interface FormulaTerm extends RosettaModelObject {

	FormulaTermMeta metaData = new FormulaTermMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The coefficient by which this term is multiplied, typically 1 or -1.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The coefficient by which this term is multiplied, typically 1 or -1.
	 *
	 */
	BigDecimal getCoefficient();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the partial derivative.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the partial derivative.
	 *
	 */
	List<? extends PricingParameterDerivativeReference> getPartialDerivativeReference();

	/*********************** Build Methods  ***********************/
	FormulaTerm build();
	
	FormulaTerm.FormulaTermBuilder toBuilder();
	
	static FormulaTerm.FormulaTermBuilder builder() {
		return new FormulaTerm.FormulaTermBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FormulaTerm> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FormulaTerm> getType() {
		return FormulaTerm.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("coefficient"), BigDecimal.class, getCoefficient(), this);
		processRosetta(path.newSubPath("partialDerivativeReference"), processor, PricingParameterDerivativeReference.class, getPartialDerivativeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FormulaTermBuilder extends FormulaTerm, RosettaModelObjectBuilder {
		PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getOrCreatePartialDerivativeReference(int index);
		@Override
		List<? extends PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder> getPartialDerivativeReference();
		FormulaTerm.FormulaTermBuilder setCoefficient(BigDecimal coefficient);
		FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference);
		FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference, int idx);
		FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(List<? extends PricingParameterDerivativeReference> partialDerivativeReference);
		FormulaTerm.FormulaTermBuilder setPartialDerivativeReference(List<? extends PricingParameterDerivativeReference> partialDerivativeReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("coefficient"), BigDecimal.class, getCoefficient(), this);
			processRosetta(path.newSubPath("partialDerivativeReference"), processor, PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder.class, getPartialDerivativeReference());
		}
		

		FormulaTerm.FormulaTermBuilder prune();
	}

	/*********************** Immutable Implementation of FormulaTerm  ***********************/
	class FormulaTermImpl implements FormulaTerm {
		private final BigDecimal coefficient;
		private final List<? extends PricingParameterDerivativeReference> partialDerivativeReference;
		
		protected FormulaTermImpl(FormulaTerm.FormulaTermBuilder builder) {
			this.coefficient = builder.getCoefficient();
			this.partialDerivativeReference = ofNullable(builder.getPartialDerivativeReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("coefficient")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coefficient")
		public BigDecimal getCoefficient() {
			return coefficient;
		}
		
		@Override
		@RosettaAttribute("partialDerivativeReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partialDerivativeReference")
		public List<? extends PricingParameterDerivativeReference> getPartialDerivativeReference() {
			return partialDerivativeReference;
		}
		
		@Override
		public FormulaTerm build() {
			return this;
		}
		
		@Override
		public FormulaTerm.FormulaTermBuilder toBuilder() {
			FormulaTerm.FormulaTermBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FormulaTerm.FormulaTermBuilder builder) {
			ofNullable(getCoefficient()).ifPresent(builder::setCoefficient);
			ofNullable(getPartialDerivativeReference()).ifPresent(builder::setPartialDerivativeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FormulaTerm _that = getType().cast(o);
		
			if (!Objects.equals(coefficient, _that.getCoefficient())) return false;
			if (!ListEquals.listEquals(partialDerivativeReference, _that.getPartialDerivativeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coefficient != null ? coefficient.hashCode() : 0);
			_result = 31 * _result + (partialDerivativeReference != null ? partialDerivativeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaTerm {" +
				"coefficient=" + this.coefficient + ", " +
				"partialDerivativeReference=" + this.partialDerivativeReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FormulaTerm  ***********************/
	class FormulaTermBuilderImpl implements FormulaTerm.FormulaTermBuilder {
	
		protected BigDecimal coefficient;
		protected List<PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder> partialDerivativeReference = new ArrayList<>();
		
		@Override
		@RosettaAttribute("coefficient")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("coefficient")
		public BigDecimal getCoefficient() {
			return coefficient;
		}
		
		@Override
		@RosettaAttribute("partialDerivativeReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partialDerivativeReference")
		public List<? extends PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder> getPartialDerivativeReference() {
			return partialDerivativeReference;
		}
		
		@Override
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getOrCreatePartialDerivativeReference(int index) {
			if (partialDerivativeReference==null) {
				this.partialDerivativeReference = new ArrayList<>();
			}
			return getIndex(partialDerivativeReference, index, () -> {
						PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder newPartialDerivativeReference = PricingParameterDerivativeReference.builder();
						return newPartialDerivativeReference;
					});
		}
		
		@RosettaAttribute("coefficient")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("coefficient")
		@Override
		public FormulaTerm.FormulaTermBuilder setCoefficient(BigDecimal _coefficient) {
			this.coefficient = _coefficient == null ? null : _coefficient;
			return this;
		}
		
		@RosettaAttribute("partialDerivativeReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partialDerivativeReference")
		@Override
		public FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(PricingParameterDerivativeReference _partialDerivativeReference) {
			if (_partialDerivativeReference != null) {
				this.partialDerivativeReference.add(_partialDerivativeReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(PricingParameterDerivativeReference _partialDerivativeReference, int idx) {
			getIndex(this.partialDerivativeReference, idx, () -> _partialDerivativeReference.toBuilder());
			return this;
		}
		
		@Override
		public FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(List<? extends PricingParameterDerivativeReference> partialDerivativeReferences) {
			if (partialDerivativeReferences != null) {
				for (final PricingParameterDerivativeReference toAdd : partialDerivativeReferences) {
					this.partialDerivativeReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partialDerivativeReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partialDerivativeReference")
		@Override
		public FormulaTerm.FormulaTermBuilder setPartialDerivativeReference(List<? extends PricingParameterDerivativeReference> partialDerivativeReferences) {
			if (partialDerivativeReferences == null) {
				this.partialDerivativeReference = new ArrayList<>();
			} else {
				this.partialDerivativeReference = partialDerivativeReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public FormulaTerm build() {
			return new FormulaTerm.FormulaTermImpl(this);
		}
		
		@Override
		public FormulaTerm.FormulaTermBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FormulaTerm.FormulaTermBuilder prune() {
			partialDerivativeReference = partialDerivativeReference.stream().filter(b->b!=null).<PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCoefficient()!=null) return true;
			if (getPartialDerivativeReference()!=null && getPartialDerivativeReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FormulaTerm.FormulaTermBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FormulaTerm.FormulaTermBuilder o = (FormulaTerm.FormulaTermBuilder) other;
			
			merger.mergeRosetta(getPartialDerivativeReference(), o.getPartialDerivativeReference(), this::getOrCreatePartialDerivativeReference);
			
			merger.mergeBasic(getCoefficient(), o.getCoefficient(), this::setCoefficient);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FormulaTerm _that = getType().cast(o);
		
			if (!Objects.equals(coefficient, _that.getCoefficient())) return false;
			if (!ListEquals.listEquals(partialDerivativeReference, _that.getPartialDerivativeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coefficient != null ? coefficient.hashCode() : 0);
			_result = 31 * _result + (partialDerivativeReference != null ? partialDerivativeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaTermBuilder {" +
				"coefficient=" + this.coefficient + ", " +
				"partialDerivativeReference=" + this.partialDerivativeReference +
			'}';
		}
	}
}
