package fpml.consolidated.business.events;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.asset.QuantityUnit;
import fpml.consolidated.business.events.meta.UnitQuantityRefMeta;
import fpml.consolidated.com.UnitQuantity;
import fpml.consolidated.shared.NotionalReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a quantity and unit with a reference.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a quantity and unit with a reference.
 *
 */
@RosettaDataType(value="UnitQuantityRef", builder=UnitQuantityRef.UnitQuantityRefBuilderImpl.class, version="2.1.1")
@RuneDataType(value="UnitQuantityRef", model="fpml", builder=UnitQuantityRef.UnitQuantityRefBuilderImpl.class, version="2.1.1")
public interface UnitQuantityRef extends UnitQuantity {

	UnitQuantityRefMeta metaData = new UnitQuantityRefMeta();

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
	NotionalReference getQuantityReference();

	/*********************** Build Methods  ***********************/
	UnitQuantityRef build();
	
	UnitQuantityRef.UnitQuantityRefBuilder toBuilder();
	
	static UnitQuantityRef.UnitQuantityRefBuilder builder() {
		return new UnitQuantityRef.UnitQuantityRefBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnitQuantityRef> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UnitQuantityRef> getType() {
		return UnitQuantityRef.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.class, getQuantityUnit());
		processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
		processRosetta(path.newSubPath("quantityReference"), processor, NotionalReference.class, getQuantityReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnitQuantityRefBuilder extends UnitQuantityRef, UnitQuantity.UnitQuantityBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateQuantityReference();
		@Override
		NotionalReference.NotionalReferenceBuilder getQuantityReference();
		@Override
		UnitQuantityRef.UnitQuantityRefBuilder setId(String id);
		@Override
		UnitQuantityRef.UnitQuantityRefBuilder setQuantityUnit(QuantityUnit quantityUnit);
		@Override
		UnitQuantityRef.UnitQuantityRefBuilder setQuantity(BigDecimal quantity);
		UnitQuantityRef.UnitQuantityRefBuilder setQuantityReference(NotionalReference quantityReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("quantityUnit"), processor, QuantityUnit.QuantityUnitBuilder.class, getQuantityUnit());
			processor.processBasic(path.newSubPath("quantity"), BigDecimal.class, getQuantity(), this);
			processRosetta(path.newSubPath("quantityReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getQuantityReference());
		}
		

		UnitQuantityRef.UnitQuantityRefBuilder prune();
	}

	/*********************** Immutable Implementation of UnitQuantityRef  ***********************/
	class UnitQuantityRefImpl extends UnitQuantity.UnitQuantityImpl implements UnitQuantityRef {
		private final NotionalReference quantityReference;
		
		protected UnitQuantityRefImpl(UnitQuantityRef.UnitQuantityRefBuilder builder) {
			super(builder);
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityReference")
		public NotionalReference getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public UnitQuantityRef build() {
			return this;
		}
		
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder toBuilder() {
			UnitQuantityRef.UnitQuantityRefBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnitQuantityRef.UnitQuantityRefBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnitQuantityRef _that = getType().cast(o);
		
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitQuantityRef {" +
				"quantityReference=" + this.quantityReference +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of UnitQuantityRef  ***********************/
	class UnitQuantityRefBuilderImpl extends UnitQuantity.UnitQuantityBuilderImpl implements UnitQuantityRef.UnitQuantityRefBuilder {
	
		protected NotionalReference.NotionalReferenceBuilder quantityReference;
		
		@Override
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityReference")
		public NotionalReference.NotionalReferenceBuilder getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateQuantityReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (quantityReference!=null) {
				result = quantityReference;
			}
			else {
				result = quantityReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantityUnit")
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder setQuantityUnit(QuantityUnit _quantityUnit) {
			this.quantityUnit = _quantityUnit == null ? null : _quantityUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quantity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("quantity")
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder setQuantity(BigDecimal _quantity) {
			this.quantity = _quantity == null ? null : _quantity;
			return this;
		}
		
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityReference")
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder setQuantityReference(NotionalReference _quantityReference) {
			this.quantityReference = _quantityReference == null ? null : _quantityReference.toBuilder();
			return this;
		}
		
		@Override
		public UnitQuantityRef build() {
			return new UnitQuantityRef.UnitQuantityRefImpl(this);
		}
		
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder prune() {
			super.prune();
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnitQuantityRef.UnitQuantityRefBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			UnitQuantityRef.UnitQuantityRefBuilder o = (UnitQuantityRef.UnitQuantityRefBuilder) other;
			
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			UnitQuantityRef _that = getType().cast(o);
		
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnitQuantityRefBuilder {" +
				"quantityReference=" + this.quantityReference +
			'}' + " " + super.toString();
		}
	}
}
