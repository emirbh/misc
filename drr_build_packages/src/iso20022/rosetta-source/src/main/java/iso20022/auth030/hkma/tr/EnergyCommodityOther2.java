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
import iso20022.auth030.hkma.tr.meta.EnergyCommodityOther2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Other energy commodity derivative.
 * @version ${project.version}
 */
@RosettaDataType(value="EnergyCommodityOther2", builder=EnergyCommodityOther2.EnergyCommodityOther2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnergyCommodityOther2", model="iso20022", builder=EnergyCommodityOther2.EnergyCommodityOther2BuilderImpl.class, version="${project.version}")
public interface EnergyCommodityOther2 extends RosettaModelObject {

	EnergyCommodityOther2Meta metaData = new EnergyCommodityOther2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType2Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType49Code getSubPdct();

	/*********************** Build Methods  ***********************/
	EnergyCommodityOther2 build();
	
	EnergyCommodityOther2.EnergyCommodityOther2Builder toBuilder();
	
	static EnergyCommodityOther2.EnergyCommodityOther2Builder builder() {
		return new EnergyCommodityOther2.EnergyCommodityOther2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnergyCommodityOther2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnergyCommodityOther2> getType() {
		return EnergyCommodityOther2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnergyCommodityOther2Builder extends EnergyCommodityOther2, RosettaModelObjectBuilder {
		EnergyCommodityOther2.EnergyCommodityOther2Builder setBasePdct(AssetClassProductType2Code basePdct);
		EnergyCommodityOther2.EnergyCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType49Code.class, getSubPdct(), this);
		}
		

		EnergyCommodityOther2.EnergyCommodityOther2Builder prune();
	}

	/*********************** Immutable Implementation of EnergyCommodityOther2  ***********************/
	class EnergyCommodityOther2Impl implements EnergyCommodityOther2 {
		private final AssetClassProductType2Code basePdct;
		private final AssetClassSubProductType49Code subPdct;
		
		protected EnergyCommodityOther2Impl(EnergyCommodityOther2.EnergyCommodityOther2Builder builder) {
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
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public EnergyCommodityOther2 build() {
			return this;
		}
		
		@Override
		public EnergyCommodityOther2.EnergyCommodityOther2Builder toBuilder() {
			EnergyCommodityOther2.EnergyCommodityOther2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnergyCommodityOther2.EnergyCommodityOther2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityOther2 _that = getType().cast(o);
		
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
			return "EnergyCommodityOther2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnergyCommodityOther2  ***********************/
	class EnergyCommodityOther2BuilderImpl implements EnergyCommodityOther2.EnergyCommodityOther2Builder {
	
		protected AssetClassProductType2Code basePdct;
		protected AssetClassSubProductType49Code subPdct;
		
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
		public AssetClassSubProductType49Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public EnergyCommodityOther2.EnergyCommodityOther2Builder setBasePdct(AssetClassProductType2Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public EnergyCommodityOther2.EnergyCommodityOther2Builder setSubPdct(AssetClassSubProductType49Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public EnergyCommodityOther2 build() {
			return new EnergyCommodityOther2.EnergyCommodityOther2Impl(this);
		}
		
		@Override
		public EnergyCommodityOther2.EnergyCommodityOther2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyCommodityOther2.EnergyCommodityOther2Builder prune() {
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
		public EnergyCommodityOther2.EnergyCommodityOther2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnergyCommodityOther2.EnergyCommodityOther2Builder o = (EnergyCommodityOther2.EnergyCommodityOther2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityOther2 _that = getType().cast(o);
		
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
			return "EnergyCommodityOther2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
