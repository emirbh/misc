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
import iso20022.auth030.fca.meta.AssetClassCommodityMultiCommodityExotic1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is multi commodity exotic.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityMultiCommodityExotic1", builder=AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityMultiCommodityExotic1", model="iso20022", builder=AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityMultiCommodityExotic1 extends RosettaModelObject {

	AssetClassCommodityMultiCommodityExotic1Meta metaData = new AssetClassCommodityMultiCommodityExotic1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType13Code getBasePdct();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityMultiCommodityExotic1 build();
	
	AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder toBuilder();
	
	static AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder builder() {
		return new AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityMultiCommodityExotic1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityMultiCommodityExotic1> getType() {
		return AssetClassCommodityMultiCommodityExotic1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType13Code.class, getBasePdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityMultiCommodityExotic1Builder extends AssetClassCommodityMultiCommodityExotic1, RosettaModelObjectBuilder {
		AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder setBasePdct(AssetClassProductType13Code basePdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType13Code.class, getBasePdct(), this);
		}
		

		AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityMultiCommodityExotic1  ***********************/
	class AssetClassCommodityMultiCommodityExotic1Impl implements AssetClassCommodityMultiCommodityExotic1 {
		private final AssetClassProductType13Code basePdct;
		
		protected AssetClassCommodityMultiCommodityExotic1Impl(AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder builder) {
			this.basePdct = builder.getBasePdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType13Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		public AssetClassCommodityMultiCommodityExotic1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder toBuilder() {
			AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityMultiCommodityExotic1 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityMultiCommodityExotic1 {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityMultiCommodityExotic1  ***********************/
	class AssetClassCommodityMultiCommodityExotic1BuilderImpl implements AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder {
	
		protected AssetClassProductType13Code basePdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType13Code getBasePdct() {
			return basePdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder setBasePdct(AssetClassProductType13Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@Override
		public AssetClassCommodityMultiCommodityExotic1 build() {
			return new AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Impl(this);
		}
		
		@Override
		public AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder o = (AssetClassCommodityMultiCommodityExotic1.AssetClassCommodityMultiCommodityExotic1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityMultiCommodityExotic1 _that = getType().cast(o);
		
			if (!Objects.equals(basePdct, _that.getBasePdct())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (basePdct != null ? basePdct.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityMultiCommodityExotic1Builder {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}
}
