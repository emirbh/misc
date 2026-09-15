package iso20022.auth030.esma;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import iso20022.auth030.esma.meta.AssetClassCommodityPolypropylene4ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is polypropylene.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityPolypropylene4Choice", builder=AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityPolypropylene4Choice", model="iso20022", builder=AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityPolypropylene4Choice extends RosettaModelObject {

	AssetClassCommodityPolypropylene4ChoiceMeta metaData = new AssetClassCommodityPolypropylene4ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Plastic commodity derivative.
	 */
	PolypropyleneCommodityPlastic2 getPlstc();
	/**
	 * Other commodity derivative
	 */
	PolypropyleneCommodityOther2 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityPolypropylene4Choice build();
	
	AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder toBuilder();
	
	static AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder builder() {
		return new AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityPolypropylene4Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityPolypropylene4Choice> getType() {
		return AssetClassCommodityPolypropylene4Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("plstc"), processor, PolypropyleneCommodityPlastic2.class, getPlstc());
		processRosetta(path.newSubPath("othr"), processor, PolypropyleneCommodityOther2.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityPolypropylene4ChoiceBuilder extends AssetClassCommodityPolypropylene4Choice, RosettaModelObjectBuilder {
		PolypropyleneCommodityPlastic2.PolypropyleneCommodityPlastic2Builder getOrCreatePlstc();
		@Override
		PolypropyleneCommodityPlastic2.PolypropyleneCommodityPlastic2Builder getPlstc();
		PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder getOrCreateOthr();
		@Override
		PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder getOthr();
		AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder setPlstc(PolypropyleneCommodityPlastic2 plstc);
		AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder setOthr(PolypropyleneCommodityOther2 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("plstc"), processor, PolypropyleneCommodityPlastic2.PolypropyleneCommodityPlastic2Builder.class, getPlstc());
			processRosetta(path.newSubPath("othr"), processor, PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder.class, getOthr());
		}
		

		AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityPolypropylene4Choice  ***********************/
	class AssetClassCommodityPolypropylene4ChoiceImpl implements AssetClassCommodityPolypropylene4Choice {
		private final PolypropyleneCommodityPlastic2 plstc;
		private final PolypropyleneCommodityOther2 othr;
		
		protected AssetClassCommodityPolypropylene4ChoiceImpl(AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder builder) {
			this.plstc = ofNullable(builder.getPlstc()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("plstc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("plstc")
		public PolypropyleneCommodityPlastic2 getPlstc() {
			return plstc;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public PolypropyleneCommodityOther2 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder toBuilder() {
			AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder builder) {
			ofNullable(getPlstc()).ifPresent(builder::setPlstc);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityPolypropylene4Choice _that = getType().cast(o);
		
			if (!Objects.equals(plstc, _that.getPlstc())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (plstc != null ? plstc.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityPolypropylene4Choice {" +
				"plstc=" + this.plstc + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityPolypropylene4Choice  ***********************/
	class AssetClassCommodityPolypropylene4ChoiceBuilderImpl implements AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder {
	
		protected PolypropyleneCommodityPlastic2.PolypropyleneCommodityPlastic2Builder plstc;
		protected PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder othr;
		
		@Override
		@RosettaAttribute("plstc")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("plstc")
		public PolypropyleneCommodityPlastic2.PolypropyleneCommodityPlastic2Builder getPlstc() {
			return plstc;
		}
		
		@Override
		public PolypropyleneCommodityPlastic2.PolypropyleneCommodityPlastic2Builder getOrCreatePlstc() {
			PolypropyleneCommodityPlastic2.PolypropyleneCommodityPlastic2Builder result;
			if (plstc!=null) {
				result = plstc;
			}
			else {
				result = plstc = PolypropyleneCommodityPlastic2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder getOthr() {
			return othr;
		}
		
		@Override
		public PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder getOrCreateOthr() {
			PolypropyleneCommodityOther2.PolypropyleneCommodityOther2Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = PolypropyleneCommodityOther2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("plstc")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("plstc")
		@Override
		public AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder setPlstc(PolypropyleneCommodityPlastic2 _plstc) {
			this.plstc = _plstc == null ? null : _plstc.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder setOthr(PolypropyleneCommodityOther2 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice build() {
			return new AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder prune() {
			if (plstc!=null && !plstc.prune().hasData()) plstc = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPlstc()!=null && getPlstc().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder o = (AssetClassCommodityPolypropylene4Choice.AssetClassCommodityPolypropylene4ChoiceBuilder) other;
			
			merger.mergeRosetta(getPlstc(), o.getPlstc(), this::setPlstc);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityPolypropylene4Choice _that = getType().cast(o);
		
			if (!Objects.equals(plstc, _that.getPlstc())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (plstc != null ? plstc.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityPolypropylene4ChoiceBuilder {" +
				"plstc=" + this.plstc + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
