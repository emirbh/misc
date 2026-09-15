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
import iso20022.auth030.hkma.tr.meta.AssetClassCommodityOther1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is other.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityOther1", builder=AssetClassCommodityOther1.AssetClassCommodityOther1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityOther1", model="iso20022", builder=AssetClassCommodityOther1.AssetClassCommodityOther1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityOther1 extends RosettaModelObject {

	AssetClassCommodityOther1Meta metaData = new AssetClassCommodityOther1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType15Code getBasePdct();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityOther1 build();
	
	AssetClassCommodityOther1.AssetClassCommodityOther1Builder toBuilder();
	
	static AssetClassCommodityOther1.AssetClassCommodityOther1Builder builder() {
		return new AssetClassCommodityOther1.AssetClassCommodityOther1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityOther1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityOther1> getType() {
		return AssetClassCommodityOther1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType15Code.class, getBasePdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityOther1Builder extends AssetClassCommodityOther1, RosettaModelObjectBuilder {
		AssetClassCommodityOther1.AssetClassCommodityOther1Builder setBasePdct(AssetClassProductType15Code basePdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType15Code.class, getBasePdct(), this);
		}
		

		AssetClassCommodityOther1.AssetClassCommodityOther1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityOther1  ***********************/
	class AssetClassCommodityOther1Impl implements AssetClassCommodityOther1 {
		private final AssetClassProductType15Code basePdct;
		
		protected AssetClassCommodityOther1Impl(AssetClassCommodityOther1.AssetClassCommodityOther1Builder builder) {
			this.basePdct = builder.getBasePdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType15Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		public AssetClassCommodityOther1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityOther1.AssetClassCommodityOther1Builder toBuilder() {
			AssetClassCommodityOther1.AssetClassCommodityOther1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityOther1.AssetClassCommodityOther1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityOther1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityOther1 {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityOther1  ***********************/
	class AssetClassCommodityOther1BuilderImpl implements AssetClassCommodityOther1.AssetClassCommodityOther1Builder {
	
		protected AssetClassProductType15Code basePdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType15Code getBasePdct() {
			return basePdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AssetClassCommodityOther1.AssetClassCommodityOther1Builder setBasePdct(AssetClassProductType15Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@Override
		public AssetClassCommodityOther1 build() {
			return new AssetClassCommodityOther1.AssetClassCommodityOther1Impl(this);
		}
		
		@Override
		public AssetClassCommodityOther1.AssetClassCommodityOther1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityOther1.AssetClassCommodityOther1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityOther1.AssetClassCommodityOther1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityOther1.AssetClassCommodityOther1Builder o = (AssetClassCommodityOther1.AssetClassCommodityOther1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityOther1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityOther1Builder {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}
}
