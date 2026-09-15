package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.BasketConstituents3__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Choice between ISIN and an alternative format for the identification of a financial instrument. ISIN is the preferred format.
 * @version ${project.version}
 */
@RosettaDataType(value="BasketConstituents3__1", builder=BasketConstituents3__1.BasketConstituents3__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="BasketConstituents3__1", model="iso20022", builder=BasketConstituents3__1.BasketConstituents3__1BuilderImpl.class, version="${project.version}")
public interface BasketConstituents3__1 extends RosettaModelObject {

	BasketConstituents3__1Meta metaData = new BasketConstituents3__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Proprietary identification of a security assigned by an institution or organisation.
	 */
	InstrumentIdentification6Choice__1 getInstrmId();
	/**
	 * Indicates the number of units of a particular constituent in a custom basket.
	 */
	BigDecimal getQty();
	/**
	 * Specifies the unit of measure in which the number of units of a particular custom basket constituent is expressed.
	 */
	UnitOfMeasure8Choice__1 getUnitOfMeasr();

	/*********************** Build Methods  ***********************/
	BasketConstituents3__1 build();
	
	BasketConstituents3__1.BasketConstituents3__1Builder toBuilder();
	
	static BasketConstituents3__1.BasketConstituents3__1Builder builder() {
		return new BasketConstituents3__1.BasketConstituents3__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasketConstituents3__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends BasketConstituents3__1> getType() {
		return BasketConstituents3__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("instrmId"), processor, InstrumentIdentification6Choice__1.class, getInstrmId());
		processor.processBasic(path.newSubPath("qty"), BigDecimal.class, getQty(), this);
		processRosetta(path.newSubPath("unitOfMeasr"), processor, UnitOfMeasure8Choice__1.class, getUnitOfMeasr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasketConstituents3__1Builder extends BasketConstituents3__1, RosettaModelObjectBuilder {
		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder getOrCreateInstrmId();
		@Override
		InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder getInstrmId();
		UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder getOrCreateUnitOfMeasr();
		@Override
		UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder getUnitOfMeasr();
		BasketConstituents3__1.BasketConstituents3__1Builder setInstrmId(InstrumentIdentification6Choice__1 instrmId);
		BasketConstituents3__1.BasketConstituents3__1Builder setQty(BigDecimal qty);
		BasketConstituents3__1.BasketConstituents3__1Builder setUnitOfMeasr(UnitOfMeasure8Choice__1 unitOfMeasr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("instrmId"), processor, InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder.class, getInstrmId());
			processor.processBasic(path.newSubPath("qty"), BigDecimal.class, getQty(), this);
			processRosetta(path.newSubPath("unitOfMeasr"), processor, UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder.class, getUnitOfMeasr());
		}
		

		BasketConstituents3__1.BasketConstituents3__1Builder prune();
	}

	/*********************** Immutable Implementation of BasketConstituents3__1  ***********************/
	class BasketConstituents3__1Impl implements BasketConstituents3__1 {
		private final InstrumentIdentification6Choice__1 instrmId;
		private final BigDecimal qty;
		private final UnitOfMeasure8Choice__1 unitOfMeasr;
		
		protected BasketConstituents3__1Impl(BasketConstituents3__1.BasketConstituents3__1Builder builder) {
			this.instrmId = ofNullable(builder.getInstrmId()).map(f->f.build()).orElse(null);
			this.qty = builder.getQty();
			this.unitOfMeasr = ofNullable(builder.getUnitOfMeasr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("instrmId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("instrmId")
		public InstrumentIdentification6Choice__1 getInstrmId() {
			return instrmId;
		}
		
		@Override
		@RosettaAttribute("qty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qty")
		public BigDecimal getQty() {
			return qty;
		}
		
		@Override
		@RosettaAttribute("unitOfMeasr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitOfMeasr")
		public UnitOfMeasure8Choice__1 getUnitOfMeasr() {
			return unitOfMeasr;
		}
		
		@Override
		public BasketConstituents3__1 build() {
			return this;
		}
		
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder toBuilder() {
			BasketConstituents3__1.BasketConstituents3__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasketConstituents3__1.BasketConstituents3__1Builder builder) {
			ofNullable(getInstrmId()).ifPresent(builder::setInstrmId);
			ofNullable(getQty()).ifPresent(builder::setQty);
			ofNullable(getUnitOfMeasr()).ifPresent(builder::setUnitOfMeasr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituents3__1 _that = getType().cast(o);
		
			if (!Objects.equals(instrmId, _that.getInstrmId())) return false;
			if (!Objects.equals(qty, _that.getQty())) return false;
			if (!Objects.equals(unitOfMeasr, _that.getUnitOfMeasr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrmId != null ? instrmId.hashCode() : 0);
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			_result = 31 * _result + (unitOfMeasr != null ? unitOfMeasr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituents3__1 {" +
				"instrmId=" + this.instrmId + ", " +
				"qty=" + this.qty + ", " +
				"unitOfMeasr=" + this.unitOfMeasr +
			'}';
		}
	}

	/*********************** Builder Implementation of BasketConstituents3__1  ***********************/
	class BasketConstituents3__1BuilderImpl implements BasketConstituents3__1.BasketConstituents3__1Builder {
	
		protected InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder instrmId;
		protected BigDecimal qty;
		protected UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder unitOfMeasr;
		
		@Override
		@RosettaAttribute("instrmId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("instrmId")
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder getInstrmId() {
			return instrmId;
		}
		
		@Override
		public InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder getOrCreateInstrmId() {
			InstrumentIdentification6Choice__1.InstrumentIdentification6Choice__1Builder result;
			if (instrmId!=null) {
				result = instrmId;
			}
			else {
				result = instrmId = InstrumentIdentification6Choice__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("qty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("qty")
		public BigDecimal getQty() {
			return qty;
		}
		
		@Override
		@RosettaAttribute("unitOfMeasr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitOfMeasr")
		public UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder getUnitOfMeasr() {
			return unitOfMeasr;
		}
		
		@Override
		public UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder getOrCreateUnitOfMeasr() {
			UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder result;
			if (unitOfMeasr!=null) {
				result = unitOfMeasr;
			}
			else {
				result = unitOfMeasr = UnitOfMeasure8Choice__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("instrmId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("instrmId")
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder setInstrmId(InstrumentIdentification6Choice__1 _instrmId) {
			this.instrmId = _instrmId == null ? null : _instrmId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("qty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("qty")
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder setQty(BigDecimal _qty) {
			this.qty = _qty == null ? null : _qty;
			return this;
		}
		
		@RosettaAttribute("unitOfMeasr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unitOfMeasr")
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder setUnitOfMeasr(UnitOfMeasure8Choice__1 _unitOfMeasr) {
			this.unitOfMeasr = _unitOfMeasr == null ? null : _unitOfMeasr.toBuilder();
			return this;
		}
		
		@Override
		public BasketConstituents3__1 build() {
			return new BasketConstituents3__1.BasketConstituents3__1Impl(this);
		}
		
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder prune() {
			if (instrmId!=null && !instrmId.prune().hasData()) instrmId = null;
			if (unitOfMeasr!=null && !unitOfMeasr.prune().hasData()) unitOfMeasr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInstrmId()!=null && getInstrmId().hasData()) return true;
			if (getQty()!=null) return true;
			if (getUnitOfMeasr()!=null && getUnitOfMeasr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasketConstituents3__1.BasketConstituents3__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasketConstituents3__1.BasketConstituents3__1Builder o = (BasketConstituents3__1.BasketConstituents3__1Builder) other;
			
			merger.mergeRosetta(getInstrmId(), o.getInstrmId(), this::setInstrmId);
			merger.mergeRosetta(getUnitOfMeasr(), o.getUnitOfMeasr(), this::setUnitOfMeasr);
			
			merger.mergeBasic(getQty(), o.getQty(), this::setQty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasketConstituents3__1 _that = getType().cast(o);
		
			if (!Objects.equals(instrmId, _that.getInstrmId())) return false;
			if (!Objects.equals(qty, _that.getQty())) return false;
			if (!Objects.equals(unitOfMeasr, _that.getUnitOfMeasr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (instrmId != null ? instrmId.hashCode() : 0);
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			_result = 31 * _result + (unitOfMeasr != null ? unitOfMeasr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasketConstituents3__1Builder {" +
				"instrmId=" + this.instrmId + ", " +
				"qty=" + this.qty + ", " +
				"unitOfMeasr=" + this.unitOfMeasr +
			'}';
		}
	}
}
