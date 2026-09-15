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
import iso20022.auth030.hkma.tr.meta.AssetClassCommodityC10Other1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is other C10.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityC10Other1", builder=AssetClassCommodityC10Other1.AssetClassCommodityC10Other1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityC10Other1", model="iso20022", builder=AssetClassCommodityC10Other1.AssetClassCommodityC10Other1BuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityC10Other1 extends RosettaModelObject {

	AssetClassCommodityC10Other1Meta metaData = new AssetClassCommodityC10Other1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Base product for the underlying asset class as specified in the classification of commodities derivatives table.
	 */
	AssetClassProductType11Code getBasePdct();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityC10Other1 build();
	
	AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder toBuilder();
	
	static AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder builder() {
		return new AssetClassCommodityC10Other1.AssetClassCommodityC10Other1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityC10Other1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityC10Other1> getType() {
		return AssetClassCommodityC10Other1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType11Code.class, getBasePdct(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityC10Other1Builder extends AssetClassCommodityC10Other1, RosettaModelObjectBuilder {
		AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder setBasePdct(AssetClassProductType11Code basePdct);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("basePdct"), AssetClassProductType11Code.class, getBasePdct(), this);
		}
		

		AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityC10Other1  ***********************/
	class AssetClassCommodityC10Other1Impl implements AssetClassCommodityC10Other1 {
		private final AssetClassProductType11Code basePdct;
		
		protected AssetClassCommodityC10Other1Impl(AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder builder) {
			this.basePdct = builder.getBasePdct();
		}
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType11Code getBasePdct() {
			return basePdct;
		}
		
		@Override
		public AssetClassCommodityC10Other1 build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder toBuilder() {
			AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder builder) {
			ofNullable(getBasePdct()).ifPresent(builder::setBasePdct);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityC10Other1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityC10Other1 {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityC10Other1  ***********************/
	class AssetClassCommodityC10Other1BuilderImpl implements AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder {
	
		protected AssetClassProductType11Code basePdct;
		
		@Override
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("basePdct")
		public AssetClassProductType11Code getBasePdct() {
			return basePdct;
		}
		
		@RosettaAttribute("basePdct")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("basePdct")
		@Override
		public AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder setBasePdct(AssetClassProductType11Code _basePdct) {
			this.basePdct = _basePdct == null ? null : _basePdct;
			return this;
		}
		
		@Override
		public AssetClassCommodityC10Other1 build() {
			return new AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Impl(this);
		}
		
		@Override
		public AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBasePdct()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder o = (AssetClassCommodityC10Other1.AssetClassCommodityC10Other1Builder) other;
			
			
			merger.mergeBasic(getBasePdct(), o.getBasePdct(), this::setBasePdct);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityC10Other1 _that = getType().cast(o);
		
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
			return "AssetClassCommodityC10Other1Builder {" +
				"basePdct=" + this.basePdct +
			'}';
		}
	}
}
