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
import iso20022.auth030.hkma.dtcc.meta.IndustrialProductCommodityManufacturing2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an industrial product derivative of type manufacturing.
 * @version ${project.version}
 */
@RosettaDataType(value="IndustrialProductCommodityManufacturing2", builder=IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="IndustrialProductCommodityManufacturing2", model="iso20022", builder=IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2BuilderImpl.class, version="${project.version}")
public interface IndustrialProductCommodityManufacturing2 extends RosettaModelObject {

	IndustrialProductCommodityManufacturing2Meta metaData = new IndustrialProductCommodityManufacturing2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType6Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType34Code getSubPdct();

	/*********************** Build Methods  ***********************/
	IndustrialProductCommodityManufacturing2 build();
	
	IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder toBuilder();
	
	static IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder builder() {
		return new IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndustrialProductCommodityManufacturing2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndustrialProductCommodityManufacturing2> getType() {
		return IndustrialProductCommodityManufacturing2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType6Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType34Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndustrialProductCommodityManufacturing2Builder extends IndustrialProductCommodityManufacturing2, RosettaModelObjectBuilder {
		IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder setBasePdct(AssetClassProductType6Code basePdct);
		IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder setSubPdct(AssetClassSubProductType34Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType6Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType34Code.class, getSubPdct(), this);
		}
		

		IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder prune();
	}

	/*********************** Immutable Implementation of IndustrialProductCommodityManufacturing2  ***********************/
	class IndustrialProductCommodityManufacturing2Impl implements IndustrialProductCommodityManufacturing2 {
		private final AssetClassProductType6Code basePdct;
		private final AssetClassSubProductType34Code subPdct;
		
		protected IndustrialProductCommodityManufacturing2Impl(IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType6Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType34Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public IndustrialProductCommodityManufacturing2 build() {
			return this;
		}
		
		@Override
		public IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder toBuilder() {
			IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndustrialProductCommodityManufacturing2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndustrialProductCommodityManufacturing2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of IndustrialProductCommodityManufacturing2  ***********************/
	class IndustrialProductCommodityManufacturing2BuilderImpl implements IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder {
	
		protected AssetClassProductType6Code basePdct;
		protected AssetClassSubProductType34Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType6Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType34Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder setBasePdct(AssetClassProductType6Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder setSubPdct(AssetClassSubProductType34Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public IndustrialProductCommodityManufacturing2 build() {
			return new IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Impl(this);
		}
		
		@Override
		public IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			if (getSubPdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder o = (IndustrialProductCommodityManufacturing2.IndustrialProductCommodityManufacturing2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndustrialProductCommodityManufacturing2 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			if (!Objects.equals(subPdct, _that.getSubPdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (subPdct != null ? subPdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndustrialProductCommodityManufacturing2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
