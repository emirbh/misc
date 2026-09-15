package iso20022.auth030.jfsa;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.jfsa.meta.NotionalQuantity9__2Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalQuantity9__2", builder=NotionalQuantity9__2.NotionalQuantity9__2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NotionalQuantity9__2", model="iso20022", builder=NotionalQuantity9__2.NotionalQuantity9__2BuilderImpl.class, version="${project.version}")
public interface NotionalQuantity9__2 extends RosettaModelObject {

	NotionalQuantity9__2Meta metaData = new NotionalQuantity9__2Meta();

	/*********************** Getter Methods  ***********************/
	BigDecimal getTtlQty();
	UnitOfMeasure8Choice__1 getUnitOfMeasr();

	/*********************** Build Methods  ***********************/
	NotionalQuantity9__2 build();
	
	NotionalQuantity9__2.NotionalQuantity9__2Builder toBuilder();
	
	static NotionalQuantity9__2.NotionalQuantity9__2Builder builder() {
		return new NotionalQuantity9__2.NotionalQuantity9__2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalQuantity9__2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalQuantity9__2> getType() {
		return NotionalQuantity9__2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ttlQty"), BigDecimal.class, getTtlQty(), this);
		processRosetta(path.newSubPath("unitOfMeasr"), processor, UnitOfMeasure8Choice__1.class, getUnitOfMeasr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalQuantity9__2Builder extends NotionalQuantity9__2, RosettaModelObjectBuilder {
		UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder getOrCreateUnitOfMeasr();
		@Override
		UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder getUnitOfMeasr();
		NotionalQuantity9__2.NotionalQuantity9__2Builder setTtlQty(BigDecimal ttlQty);
		NotionalQuantity9__2.NotionalQuantity9__2Builder setUnitOfMeasr(UnitOfMeasure8Choice__1 unitOfMeasr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("ttlQty"), BigDecimal.class, getTtlQty(), this);
			processRosetta(path.newSubPath("unitOfMeasr"), processor, UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder.class, getUnitOfMeasr());
		}
		

		NotionalQuantity9__2.NotionalQuantity9__2Builder prune();
	}

	/*********************** Immutable Implementation of NotionalQuantity9__2  ***********************/
	class NotionalQuantity9__2Impl implements NotionalQuantity9__2 {
		private final BigDecimal ttlQty;
		private final UnitOfMeasure8Choice__1 unitOfMeasr;
		
		protected NotionalQuantity9__2Impl(NotionalQuantity9__2.NotionalQuantity9__2Builder builder) {
			this.ttlQty = builder.getTtlQty();
			this.unitOfMeasr = ofNullable(builder.getUnitOfMeasr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ttlQty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ttlQty")
		public BigDecimal getTtlQty() {
			return ttlQty;
		}
		
		@Override
		@RosettaAttribute("unitOfMeasr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("unitOfMeasr")
		public UnitOfMeasure8Choice__1 getUnitOfMeasr() {
			return unitOfMeasr;
		}
		
		@Override
		public NotionalQuantity9__2 build() {
			return this;
		}
		
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder toBuilder() {
			NotionalQuantity9__2.NotionalQuantity9__2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalQuantity9__2.NotionalQuantity9__2Builder builder) {
			ofNullable(getTtlQty()).ifPresent(builder::setTtlQty);
			ofNullable(getUnitOfMeasr()).ifPresent(builder::setUnitOfMeasr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantity9__2 _that = getType().cast(o);
		
			if (!Objects.equals(ttlQty, _that.getTtlQty())) return false;
			if (!Objects.equals(unitOfMeasr, _that.getUnitOfMeasr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ttlQty != null ? ttlQty.hashCode() : 0);
			_result = 31 * _result + (unitOfMeasr != null ? unitOfMeasr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantity9__2 {" +
				"ttlQty=" + this.ttlQty + ", " +
				"unitOfMeasr=" + this.unitOfMeasr +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalQuantity9__2  ***********************/
	class NotionalQuantity9__2BuilderImpl implements NotionalQuantity9__2.NotionalQuantity9__2Builder {
	
		protected BigDecimal ttlQty;
		protected UnitOfMeasure8Choice__1.UnitOfMeasure8Choice__1Builder unitOfMeasr;
		
		@Override
		@RosettaAttribute("ttlQty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ttlQty")
		public BigDecimal getTtlQty() {
			return ttlQty;
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
		
		@RosettaAttribute("ttlQty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ttlQty")
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder setTtlQty(BigDecimal _ttlQty) {
			this.ttlQty = _ttlQty == null ? null : _ttlQty;
			return this;
		}
		
		@RosettaAttribute("unitOfMeasr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("unitOfMeasr")
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder setUnitOfMeasr(UnitOfMeasure8Choice__1 _unitOfMeasr) {
			this.unitOfMeasr = _unitOfMeasr == null ? null : _unitOfMeasr.toBuilder();
			return this;
		}
		
		@Override
		public NotionalQuantity9__2 build() {
			return new NotionalQuantity9__2.NotionalQuantity9__2Impl(this);
		}
		
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder prune() {
			if (unitOfMeasr!=null && !unitOfMeasr.prune().hasData()) unitOfMeasr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTtlQty()!=null) return true;
			if (getUnitOfMeasr()!=null && getUnitOfMeasr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalQuantity9__2.NotionalQuantity9__2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalQuantity9__2.NotionalQuantity9__2Builder o = (NotionalQuantity9__2.NotionalQuantity9__2Builder) other;
			
			merger.mergeRosetta(getUnitOfMeasr(), o.getUnitOfMeasr(), this::setUnitOfMeasr);
			
			merger.mergeBasic(getTtlQty(), o.getTtlQty(), this::setTtlQty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalQuantity9__2 _that = getType().cast(o);
		
			if (!Objects.equals(ttlQty, _that.getTtlQty())) return false;
			if (!Objects.equals(unitOfMeasr, _that.getUnitOfMeasr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ttlQty != null ? ttlQty.hashCode() : 0);
			_result = 31 * _result + (unitOfMeasr != null ? unitOfMeasr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalQuantity9__2Builder {" +
				"ttlQty=" + this.ttlQty + ", " +
				"unitOfMeasr=" + this.unitOfMeasr +
			'}';
		}
	}
}
