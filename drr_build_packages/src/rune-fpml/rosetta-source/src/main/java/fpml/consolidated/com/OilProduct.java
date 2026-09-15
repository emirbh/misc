package fpml.consolidated.com;

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
import fpml.consolidated.com.meta.OilProductMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The specification of the oil product to be delivered.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The specification of the oil product to be delivered.
 *
 */
@RosettaDataType(value="OilProduct", builder=OilProduct.OilProductBuilderImpl.class, version="2.1.1")
@RuneDataType(value="OilProduct", model="fpml", builder=OilProduct.OilProductBuilderImpl.class, version="2.1.1")
public interface OilProduct extends RosettaModelObject {

	OilProductMeta metaData = new OilProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of oil product to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of oil product to be delivered.
	 *
	 */
	OilProductType _getType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The grade of oil product to be delivered.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The grade of oil product to be delivered.
	 *
	 */
	CommodityProductGrade getGrade();

	/*********************** Build Methods  ***********************/
	OilProduct build();
	
	OilProduct.OilProductBuilder toBuilder();
	
	static OilProduct.OilProductBuilder builder() {
		return new OilProduct.OilProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilProduct> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends OilProduct> getType() {
		return OilProduct.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, OilProductType.class, _getType());
		processRosetta(path.newSubPath("grade"), processor, CommodityProductGrade.class, getGrade());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilProductBuilder extends OilProduct, RosettaModelObjectBuilder {
		OilProductType.OilProductTypeBuilder getOrCreateType();
		@Override
		OilProductType.OilProductTypeBuilder _getType();
		CommodityProductGrade.CommodityProductGradeBuilder getOrCreateGrade();
		@Override
		CommodityProductGrade.CommodityProductGradeBuilder getGrade();
		OilProduct.OilProductBuilder setType(OilProductType type);
		OilProduct.OilProductBuilder setGrade(CommodityProductGrade grade);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, OilProductType.OilProductTypeBuilder.class, _getType());
			processRosetta(path.newSubPath("grade"), processor, CommodityProductGrade.CommodityProductGradeBuilder.class, getGrade());
		}
		

		OilProduct.OilProductBuilder prune();
	}

	/*********************** Immutable Implementation of OilProduct  ***********************/
	class OilProductImpl implements OilProduct {
		private final OilProductType type;
		private final CommodityProductGrade grade;
		
		protected OilProductImpl(OilProduct.OilProductBuilder builder) {
			this.type = ofNullable(builder._getType()).map(f->f.build()).orElse(null);
			this.grade = ofNullable(builder.getGrade()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public OilProductType _getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("grade")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("grade")
		public CommodityProductGrade getGrade() {
			return grade;
		}
		
		@Override
		public OilProduct build() {
			return this;
		}
		
		@Override
		public OilProduct.OilProductBuilder toBuilder() {
			OilProduct.OilProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilProduct.OilProductBuilder builder) {
			ofNullable(_getType()).ifPresent(builder::setType);
			ofNullable(getGrade()).ifPresent(builder::setGrade);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(grade, _that.getGrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilProduct {" +
				"type=" + this.type + ", " +
				"grade=" + this.grade +
			'}';
		}
	}

	/*********************** Builder Implementation of OilProduct  ***********************/
	class OilProductBuilderImpl implements OilProduct.OilProductBuilder {
	
		protected OilProductType.OilProductTypeBuilder type;
		protected CommodityProductGrade.CommodityProductGradeBuilder grade;
		
		@Override
		@RosettaAttribute("type")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("type")
		public OilProductType.OilProductTypeBuilder _getType() {
			return type;
		}
		
		@Override
		public OilProductType.OilProductTypeBuilder getOrCreateType() {
			OilProductType.OilProductTypeBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = OilProductType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("grade")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("grade")
		public CommodityProductGrade.CommodityProductGradeBuilder getGrade() {
			return grade;
		}
		
		@Override
		public CommodityProductGrade.CommodityProductGradeBuilder getOrCreateGrade() {
			CommodityProductGrade.CommodityProductGradeBuilder result;
			if (grade!=null) {
				result = grade;
			}
			else {
				result = grade = CommodityProductGrade.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("type")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("type")
		@Override
		public OilProduct.OilProductBuilder setType(OilProductType _type) {
			this.type = _type == null ? null : _type.toBuilder();
			return this;
		}
		
		@RosettaAttribute("grade")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("grade")
		@Override
		public OilProduct.OilProductBuilder setGrade(CommodityProductGrade _grade) {
			this.grade = _grade == null ? null : _grade.toBuilder();
			return this;
		}
		
		@Override
		public OilProduct build() {
			return new OilProduct.OilProductImpl(this);
		}
		
		@Override
		public OilProduct.OilProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilProduct.OilProductBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			if (grade!=null && !grade.prune().hasData()) grade = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (_getType()!=null && _getType().hasData()) return true;
			if (getGrade()!=null && getGrade().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilProduct.OilProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OilProduct.OilProductBuilder o = (OilProduct.OilProductBuilder) other;
			
			merger.mergeRosetta(_getType(), o._getType(), this::setType);
			merger.mergeRosetta(getGrade(), o.getGrade(), this::setGrade);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilProduct _that = getType().cast(o);
		
			if (!Objects.equals(type, _that._getType())) return false;
			if (!Objects.equals(grade, _that.getGrade())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (grade != null ? grade.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilProductBuilder {" +
				"type=" + this.type + ", " +
				"grade=" + this.grade +
			'}';
		}
	}
}
