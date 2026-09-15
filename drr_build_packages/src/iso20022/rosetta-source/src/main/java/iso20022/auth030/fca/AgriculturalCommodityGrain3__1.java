package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.AgriculturalCommodityGrain3__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an agricultural derivative of type grain.
 * @version ${project.version}
 */
@RosettaDataType(value="AgriculturalCommodityGrain3__1", builder=AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AgriculturalCommodityGrain3__1", model="iso20022", builder=AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1BuilderImpl.class, version="${project.version}")
public interface AgriculturalCommodityGrain3__1 extends RosettaModelObject {

	AgriculturalCommodityGrain3__1Meta metaData = new AgriculturalCommodityGrain3__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType1Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType5Code getSubPdct();
	/**
	 * Further subproduct type related to instruments that have a non-financial instrument or commodity as underlying.
	 */
	AssetClassDetailedSubProductType30Code getAddtlSubPdct();

	/*********************** Build Methods  ***********************/
	AgriculturalCommodityGrain3__1 build();
	
	AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder toBuilder();
	
	static AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder builder() {
		return new AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AgriculturalCommodityGrain3__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AgriculturalCommodityGrain3__1> getType() {
		return AgriculturalCommodityGrain3__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType5Code.class, getSubPdct(), this);
		processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType30Code.class, getAddtlSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AgriculturalCommodityGrain3__1Builder extends AgriculturalCommodityGrain3__1, RosettaModelObjectBuilder {
		AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder setBasePdct(AssetClassProductType1Code basePdct);
		AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder setSubPdct(AssetClassSubProductType5Code subPdct);
		AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder setAddtlSubPdct(AssetClassDetailedSubProductType30Code addtlSubPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType1Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType5Code.class, getSubPdct(), this);
			processor.processBasic(path.newSubPath("addtlSubPdct"), AssetClassDetailedSubProductType30Code.class, getAddtlSubPdct(), this);
		}
		

		AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder prune();
	}

	/*********************** Immutable Implementation of AgriculturalCommodityGrain3__1  ***********************/
	class AgriculturalCommodityGrain3__1Impl implements AgriculturalCommodityGrain3__1 {
		private final AssetClassProductType1Code basePdct;
		private final AssetClassSubProductType5Code subPdct;
		private final AssetClassDetailedSubProductType30Code addtlSubPdct;
		
		protected AgriculturalCommodityGrain3__1Impl(AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder builder) {
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
		@Required
		@RuneAttribute("subPdct")
		public AssetClassSubProductType5Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType30Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@Override
		public AgriculturalCommodityGrain3__1 build() {
			return this;
		}
		
		@Override
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder toBuilder() {
			AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
			ofNullable(getAddtlSubPdct()).ifPresent(builder::setAddtlSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityGrain3__1 _that = getType().cast(o);
		
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
			return "AgriculturalCommodityGrain3__1 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AgriculturalCommodityGrain3__1  ***********************/
	class AgriculturalCommodityGrain3__1BuilderImpl implements AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder {
	
		protected AssetClassProductType1Code basePdct;
		protected AssetClassSubProductType5Code subPdct;
		protected AssetClassDetailedSubProductType30Code addtlSubPdct;
		
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
		@Required
		@RuneAttribute("subPdct")
		public AssetClassSubProductType5Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("addtlSubPdct")
		public AssetClassDetailedSubProductType30Code getAddtlSubPdct() {
			return addtlSubPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder setBasePdct(AssetClassProductType1Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("subPdct")
		@Override
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder setSubPdct(AssetClassSubProductType5Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@RosettaAttribute("addtlSubPdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("addtlSubPdct")
		@Override
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder setAddtlSubPdct(AssetClassDetailedSubProductType30Code _addtlSubPdct) {
			this.addtlSubPdct = _addtlSubPdct == null ? null : _addtlSubPdct;
			return this;
		}
		
		@Override
		public AgriculturalCommodityGrain3__1 build() {
			return new AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Impl(this);
		}
		
		@Override
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder prune() {
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
		public AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder o = (AgriculturalCommodityGrain3__1.AgriculturalCommodityGrain3__1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			merger.mergeBasic(getAddtlSubPdct(), o.getAddtlSubPdct(), this::setAddtlSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AgriculturalCommodityGrain3__1 _that = getType().cast(o);
		
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
			return "AgriculturalCommodityGrain3__1Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct + ", " +
				"addtlSubPdct=" + this.addtlSubPdct +
			'}';
		}
	}
}
