package iso20022.auth030.esma;

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
import iso20022.auth030.esma.meta.EnergyCommodityInterEnergy2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity sub-product attributes of an energy derivative of type inter energy.
 * @version ${project.version}
 */
@RosettaDataType(value="EnergyCommodityInterEnergy2", builder=EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2BuilderImpl.class, version="${project.version}")
@RuneDataType(value="EnergyCommodityInterEnergy2", model="iso20022", builder=EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2BuilderImpl.class, version="${project.version}")
public interface EnergyCommodityInterEnergy2 extends RosettaModelObject {

	EnergyCommodityInterEnergy2Meta metaData = new EnergyCommodityInterEnergy2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType2Code getBasePdct();
	/**
	 * Sub-product for the underlying asset class.
	 */
	AssetClassSubProductType26Code getSubPdct();

	/*********************** Build Methods  ***********************/
	EnergyCommodityInterEnergy2 build();
	
	EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder toBuilder();
	
	static EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder builder() {
		return new EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnergyCommodityInterEnergy2> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EnergyCommodityInterEnergy2> getType() {
		return EnergyCommodityInterEnergy2.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
		processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType26Code.class, getSubPdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnergyCommodityInterEnergy2Builder extends EnergyCommodityInterEnergy2, RosettaModelObjectBuilder {
		EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder setBasePdct(AssetClassProductType2Code basePdct);
		EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder setSubPdct(AssetClassSubProductType26Code subPdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType2Code.class, getBasePdct(), this);
			processor.processBasic(path.newSubPath("subPdct"), AssetClassSubProductType26Code.class, getSubPdct(), this);
		}
		

		EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder prune();
	}

	/*********************** Immutable Implementation of EnergyCommodityInterEnergy2  ***********************/
	class EnergyCommodityInterEnergy2Impl implements EnergyCommodityInterEnergy2 {
		private final AssetClassProductType2Code basePdct;
		private final AssetClassSubProductType26Code subPdct;
		
		protected EnergyCommodityInterEnergy2Impl(EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder builder) {
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
		public AssetClassSubProductType26Code getSubPdct() {
			return subPdct;
		}
		
		@Override
		public EnergyCommodityInterEnergy2 build() {
			return this;
		}
		
		@Override
		public EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder toBuilder() {
			EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
			ofNullable(getSubPdct()).ifPresent(builder::setSubPdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityInterEnergy2 _that = getType().cast(o);
		
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
			return "EnergyCommodityInterEnergy2 {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}

	/*********************** Builder Implementation of EnergyCommodityInterEnergy2  ***********************/
	class EnergyCommodityInterEnergy2BuilderImpl implements EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder {
	
		protected AssetClassProductType2Code basePdct;
		protected AssetClassSubProductType26Code subPdct;
		
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
		public AssetClassSubProductType26Code getSubPdct() {
			return subPdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder setBasePdct(AssetClassProductType2Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@RosettaAttribute("subPdct")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("subPdct")
		@Override
		public EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder setSubPdct(AssetClassSubProductType26Code _subPdct) {
			this.subPdct = _subPdct == null ? null : _subPdct;
			return this;
		}
		
		@Override
		public EnergyCommodityInterEnergy2 build() {
			return new EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Impl(this);
		}
		
		@Override
		public EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder prune() {
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
		public EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder o = (EnergyCommodityInterEnergy2.EnergyCommodityInterEnergy2Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			merger.mergeBasic(getSubPdct(), o.getSubPdct(), this::setSubPdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnergyCommodityInterEnergy2 _that = getType().cast(o);
		
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
			return "EnergyCommodityInterEnergy2Builder {" +
				"basePdct=" + this.basePdct + ", " +
				"subPdct=" + this.subPdct +
			'}';
		}
	}
}
