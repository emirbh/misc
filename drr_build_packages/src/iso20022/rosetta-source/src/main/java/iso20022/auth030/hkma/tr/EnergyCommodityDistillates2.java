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
import iso20022.auth030.hkma.tr.meta.EnergyCommodityDistillates2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an energy derivative of type distillates.
 * @version ${project.version}
 */
@RosettaDataType(value="EnergyCommodityDistillates2", builder=EnergyCommodityDistillates2.EnergyCommodityDistillates2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnergyCommodityDistillates2", model="iso20022", builder=EnergyCommodityDistillates2.EnergyCommodityDistillates2BuilderImpl.class, version="${project.version}")
public interface EnergyCommodityDistillates2 extends RosettaModelObject {

	EnergyCommodityDistillates2Meta metaData = new EnergyCommodityDistillates2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType2Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType25Code getSubPdct();

	/*********************** Build Methods  ***********************/
	EnergyCommodityDistillates2 build();
	
	EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder toBuilder();
	
	static EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder builder() {
		return new EnergyCommodityDistillates2.EnergyCommodityDistillates2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnergyCommodityDistillates2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnergyCommodityDistillates2> getType() {
		return EnergyCommodityDistillates2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType25Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnergyCommodityDistillates2Builder extends EnergyCommodityDistillates2, RosettaModelObjectBuilder {
		EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder setBasePdct(AssetClassProductType2Code basePdct);
		EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder setSubPdct(AssetClassSubProductType25Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType25Code.class, getSubPdct(), this);
		}
		

		EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder prune();
	}

	/*********************** Immutable Implementation of EnergyCommodityDistillates2  ***********************/
	class EnergyCommodityDistillates2Impl implements EnergyCommodityDistillates2 {
		private final AssetClassProductType2Code basePdct;
		private final AssetClassSubProductType25Code subPdct;
		
		protected EnergyCommodityDistillates2Impl(EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder builder) {
			this.basePdct = builder.getBasePdct();
			this.subPdct = builder.getSubPdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType2Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType25Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public EnergyCommodityDistillates2 build() {
			return this;
		}
		
		@Override
		public EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder toBuilder() {
			EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityDistillates2 _that = getType().cast(o);
		
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
			return "EnergyCommodityDistillates2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnergyCommodityDistillates2  ***********************/
	class EnergyCommodityDistillates2BuilderImpl implements EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder {
	
		protected AssetClassProductType2Code basePdct;
		protected AssetClassSubProductType25Code subPdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType2Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("subPdct")
		public AssetClassSubProductType25Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder setBasePdct(AssetClassProductType2Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder setSubPdct(AssetClassSubProductType25Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public EnergyCommodityDistillates2 build() {
			return new EnergyCommodityDistillates2.EnergyCommodityDistillates2Impl(this);
		}
		
		@Override
		public EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder prune() {
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
		public EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder o = (EnergyCommodityDistillates2.EnergyCommodityDistillates2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityDistillates2 _that = getType().cast(o);
		
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
			return "EnergyCommodityDistillates2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
