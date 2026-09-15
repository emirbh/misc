package iso20022.auth030.hkma.dtcc;

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
import iso20022.auth030.hkma.dtcc.meta.AgriculturalCommodityOliveOil3Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an agricultural derivative of type olive oil.
 * @version ${project.version}
 */
@RosettaDataType(value="AgriculturalCommodityOliveOil3", builder=AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AgriculturalCommodityOliveOil3", model="iso20022", builder=AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3BuilderImpl.class, version="${project.version}")
public interface AgriculturalCommodityOliveOil3 extends RosettaModelObject {

	AgriculturalCommodityOliveOil3Meta metaData = new AgriculturalCommodityOliveOil3Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType1Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType3Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType29Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	AgriculturalCommodityOliveOil3 build();
	
	AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder toBuilder();
	
	static AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder builder() {
		return new AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgriculturalCommodityOliveOil3> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgriculturalCommodityOliveOil3> getType() {
		return AgriculturalCommodityOliveOil3.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType3Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType29Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgriculturalCommodityOliveOil3Builder extends AgriculturalCommodityOliveOil3, RosettaModelObjectBuilder {
		AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder setBasePdct(AssetClassProductType1Code basePdct);
		AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder setSubPdct(AssetClassSubProductType3Code subPdct);
		AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder setAddtlSubPdct(AssetClassDetailedSubProductType29Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType3Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType29Code.class, getAddtlSubPdct(), this);
		}
		

		AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder prune();
	}

	/*********************** Immutable Implementation of AgriculturalCommodityOliveOil3  ***********************/
	class AgriculturalCommodityOliveOil3Impl implements AgriculturalCommodityOliveOil3 {
		private final AssetClassProductType1Code basePdct;
		private final AssetClassSubProductType3Code subPdct;
		private final AssetClassDetailedSubProductType29Code addtlSubPdct;
		
		protected AgriculturalCommodityOliveOil3Impl(AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
			this.addtlSubPdct = builder.getAddtlSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType1Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType3Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType29Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public AgriculturalCommodityOliveOil3 build() {
			return this;
		}
		
		@Override
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder toBuilder() {
			AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityOliveOil3 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			if (!Objects.equals(addtlSubPdct, _that.getAddtlSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (addtlSubPdct != null ? addtlSubPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgriculturalCommodityOliveOil3 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AgriculturalCommodityOliveOil3  ***********************/
	class AgriculturalCommodityOliveOil3BuilderImpl implements AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder {
	
		protected AssetClassProductType1Code basePdct;
		protected AssetClassSubProductType3Code subPdct;
		protected AssetClassDetailedSubProductType29Code addtlSubPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType1Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType3Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType29Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder setBasePdct(AssetClassProductType1Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder setSubPdct(AssetClassSubProductType3Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("addtlSubPdct")
		@Override
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder setAddtlSubPdct(AssetClassDetailedSubProductType29Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public AgriculturalCommodityOliveOil3 build() {
			return new AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Impl(this);
		}
		
		@Override
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			if (getSubPdct()!=null) return true;
			if (getAddtlSubPdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder o = (AgriculturalCommodityOliveOil3.AgriculturalCommodityOliveOil3Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityOliveOil3 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			if (!Objects.equals(addtlSubPdct, _that.getAddtlSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (addtlSubPdct != null ? addtlSubPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AgriculturalCommodityOliveOil3Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
