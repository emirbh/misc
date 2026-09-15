package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.AssetClassCommodityFertilizer4ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines commodity attributes of a derivative where the type is fertilizer.
 * @version ${project.version}
 */
@RosettaDataType(value="AssetClassCommodityFertilizer4Choice", builder=AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="AssetClassCommodityFertilizer4Choice", model="iso20022", builder=AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilderImpl.class, version="${project.version}")
public interface AssetClassCommodityFertilizer4Choice extends RosettaModelObject {

	AssetClassCommodityFertilizer4ChoiceMeta metaData = new AssetClassCommodityFertilizer4ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Ammonia fertilizer commodity derivative.
	 */
	FertilizerCommodityAmmonia2 getAmmn();
	/**
	 * Diammonium phosphate fertilizer commodity derivative.
	 */
	FertilizerCommodityDiammoniumPhosphate2 getDmmnmPhspht();
	/**
	 * Potash fertilizer commodity derivative.
	 */
	FertilizerCommodityPotash2 getPtsh();
	/**
	 * Sulphur fertilizer commodity derivative.
	 */
	FertilizerCommoditySulphur2 getSlphr();
	/**
	 * Urea fertilizer commodity derivative.
	 */
	FertilizerCommodityUrea2 getUrea();
	/**
	 * Urea and ammonium nitrate fertilizer commodity derivative.
	 */
	FertilizerCommodityUreaAndAmmoniumNitrate2 getUreaAndAmmnmNtrt();
	/**
	 * Other fertilizer commodity derivative.
	 */
	FertilizerCommodityOther2 getOthr();

	/*********************** Build Methods  ***********************/
	AssetClassCommodityFertilizer4Choice build();
	
	AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder toBuilder();
	
	static AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder builder() {
		return new AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AssetClassCommodityFertilizer4Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AssetClassCommodityFertilizer4Choice> getType() {
		return AssetClassCommodityFertilizer4Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("ammn"), processor, FertilizerCommodityAmmonia2.class, getAmmn());
		processRosetta(path.newSubPath("dmmnmPhspht"), processor, FertilizerCommodityDiammoniumPhosphate2.class, getDmmnmPhspht());
		processRosetta(path.newSubPath("ptsh"), processor, FertilizerCommodityPotash2.class, getPtsh());
		processRosetta(path.newSubPath("slphr"), processor, FertilizerCommoditySulphur2.class, getSlphr());
		processRosetta(path.newSubPath("urea"), processor, FertilizerCommodityUrea2.class, getUrea());
		processRosetta(path.newSubPath("ureaAndAmmnmNtrt"), processor, FertilizerCommodityUreaAndAmmoniumNitrate2.class, getUreaAndAmmnmNtrt());
		processRosetta(path.newSubPath("othr"), processor, FertilizerCommodityOther2.class, getOthr());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AssetClassCommodityFertilizer4ChoiceBuilder extends AssetClassCommodityFertilizer4Choice, RosettaModelObjectBuilder {
		FertilizerCommodityAmmonia2.FertilizerCommodityAmmonia2Builder getOrCreateAmmn();
		@Override
		FertilizerCommodityAmmonia2.FertilizerCommodityAmmonia2Builder getAmmn();
		FertilizerCommodityDiammoniumPhosphate2.FertilizerCommodityDiammoniumPhosphate2Builder getOrCreateDmmnmPhspht();
		@Override
		FertilizerCommodityDiammoniumPhosphate2.FertilizerCommodityDiammoniumPhosphate2Builder getDmmnmPhspht();
		FertilizerCommodityPotash2.FertilizerCommodityPotash2Builder getOrCreatePtsh();
		@Override
		FertilizerCommodityPotash2.FertilizerCommodityPotash2Builder getPtsh();
		FertilizerCommoditySulphur2.FertilizerCommoditySulphur2Builder getOrCreateSlphr();
		@Override
		FertilizerCommoditySulphur2.FertilizerCommoditySulphur2Builder getSlphr();
		FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder getOrCreateUrea();
		@Override
		FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder getUrea();
		FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder getOrCreateUreaAndAmmnmNtrt();
		@Override
		FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder getUreaAndAmmnmNtrt();
		FertilizerCommodityOther2.FertilizerCommodityOther2Builder getOrCreateOthr();
		@Override
		FertilizerCommodityOther2.FertilizerCommodityOther2Builder getOthr();
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setAmmn(FertilizerCommodityAmmonia2 ammn);
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setDmmnmPhspht(FertilizerCommodityDiammoniumPhosphate2 dmmnmPhspht);
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setPtsh(FertilizerCommodityPotash2 ptsh);
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setSlphr(FertilizerCommoditySulphur2 slphr);
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setUrea(FertilizerCommodityUrea2 urea);
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setUreaAndAmmnmNtrt(FertilizerCommodityUreaAndAmmoniumNitrate2 ureaAndAmmnmNtrt);
		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setOthr(FertilizerCommodityOther2 othr);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("ammn"), processor, FertilizerCommodityAmmonia2.FertilizerCommodityAmmonia2Builder.class, getAmmn());
			processRosetta(path.newSubPath("dmmnmPhspht"), processor, FertilizerCommodityDiammoniumPhosphate2.FertilizerCommodityDiammoniumPhosphate2Builder.class, getDmmnmPhspht());
			processRosetta(path.newSubPath("ptsh"), processor, FertilizerCommodityPotash2.FertilizerCommodityPotash2Builder.class, getPtsh());
			processRosetta(path.newSubPath("slphr"), processor, FertilizerCommoditySulphur2.FertilizerCommoditySulphur2Builder.class, getSlphr());
			processRosetta(path.newSubPath("urea"), processor, FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder.class, getUrea());
			processRosetta(path.newSubPath("ureaAndAmmnmNtrt"), processor, FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder.class, getUreaAndAmmnmNtrt());
			processRosetta(path.newSubPath("othr"), processor, FertilizerCommodityOther2.FertilizerCommodityOther2Builder.class, getOthr());
		}
		

		AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of AssetClassCommodityFertilizer4Choice  ***********************/
	class AssetClassCommodityFertilizer4ChoiceImpl implements AssetClassCommodityFertilizer4Choice {
		private final FertilizerCommodityAmmonia2 ammn;
		private final FertilizerCommodityDiammoniumPhosphate2 dmmnmPhspht;
		private final FertilizerCommodityPotash2 ptsh;
		private final FertilizerCommoditySulphur2 slphr;
		private final FertilizerCommodityUrea2 urea;
		private final FertilizerCommodityUreaAndAmmoniumNitrate2 ureaAndAmmnmNtrt;
		private final FertilizerCommodityOther2 othr;
		
		protected AssetClassCommodityFertilizer4ChoiceImpl(AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder builder) {
			this.ammn = ofNullable(builder.getAmmn()).map(f->f.build()).orElse(null);
			this.dmmnmPhspht = ofNullable(builder.getDmmnmPhspht()).map(f->f.build()).orElse(null);
			this.ptsh = ofNullable(builder.getPtsh()).map(f->f.build()).orElse(null);
			this.slphr = ofNullable(builder.getSlphr()).map(f->f.build()).orElse(null);
			this.urea = ofNullable(builder.getUrea()).map(f->f.build()).orElse(null);
			this.ureaAndAmmnmNtrt = ofNullable(builder.getUreaAndAmmnmNtrt()).map(f->f.build()).orElse(null);
			this.othr = ofNullable(builder.getOthr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("ammn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ammn")
		public FertilizerCommodityAmmonia2 getAmmn() {
			return ammn;
		}
		
		@Override
		@RosettaAttribute("dmmnmPhspht")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dmmnmPhspht")
		public FertilizerCommodityDiammoniumPhosphate2 getDmmnmPhspht() {
			return dmmnmPhspht;
		}
		
		@Override
		@RosettaAttribute("ptsh")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptsh")
		public FertilizerCommodityPotash2 getPtsh() {
			return ptsh;
		}
		
		@Override
		@RosettaAttribute("slphr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("slphr")
		public FertilizerCommoditySulphur2 getSlphr() {
			return slphr;
		}
		
		@Override
		@RosettaAttribute("urea")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("urea")
		public FertilizerCommodityUrea2 getUrea() {
			return urea;
		}
		
		@Override
		@RosettaAttribute("ureaAndAmmnmNtrt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ureaAndAmmnmNtrt")
		public FertilizerCommodityUreaAndAmmoniumNitrate2 getUreaAndAmmnmNtrt() {
			return ureaAndAmmnmNtrt;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public FertilizerCommodityOther2 getOthr() {
			return othr;
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice build() {
			return this;
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder toBuilder() {
			AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder builder) {
			ofNullable(getAmmn()).ifPresent(builder::setAmmn);
			ofNullable(getDmmnmPhspht()).ifPresent(builder::setDmmnmPhspht);
			ofNullable(getPtsh()).ifPresent(builder::setPtsh);
			ofNullable(getSlphr()).ifPresent(builder::setSlphr);
			ofNullable(getUrea()).ifPresent(builder::setUrea);
			ofNullable(getUreaAndAmmnmNtrt()).ifPresent(builder::setUreaAndAmmnmNtrt);
			ofNullable(getOthr()).ifPresent(builder::setOthr);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityFertilizer4Choice _that = getType().cast(o);
		
			if (!Objects.equals(ammn, _that.getAmmn())) return false;
			if (!Objects.equals(dmmnmPhspht, _that.getDmmnmPhspht())) return false;
			if (!Objects.equals(ptsh, _that.getPtsh())) return false;
			if (!Objects.equals(slphr, _that.getSlphr())) return false;
			if (!Objects.equals(urea, _that.getUrea())) return false;
			if (!Objects.equals(ureaAndAmmnmNtrt, _that.getUreaAndAmmnmNtrt())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ammn != null ? ammn.hashCode() : 0);
			_result = 31 * _result + (dmmnmPhspht != null ? dmmnmPhspht.hashCode() : 0);
			_result = 31 * _result + (ptsh != null ? ptsh.hashCode() : 0);
			_result = 31 * _result + (slphr != null ? slphr.hashCode() : 0);
			_result = 31 * _result + (urea != null ? urea.hashCode() : 0);
			_result = 31 * _result + (ureaAndAmmnmNtrt != null ? ureaAndAmmnmNtrt.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityFertilizer4Choice {" +
				"ammn=" + this.ammn + ", " +
				"dmmnmPhspht=" + this.dmmnmPhspht + ", " +
				"ptsh=" + this.ptsh + ", " +
				"slphr=" + this.slphr + ", " +
				"urea=" + this.urea + ", " +
				"ureaAndAmmnmNtrt=" + this.ureaAndAmmnmNtrt + ", " +
				"othr=" + this.othr +
			'}';
		}
	}

	/*********************** Builder Implementation of AssetClassCommodityFertilizer4Choice  ***********************/
	class AssetClassCommodityFertilizer4ChoiceBuilderImpl implements AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder {
	
		protected FertilizerCommodityAmmonia2.FertilizerCommodityAmmonia2Builder ammn;
		protected FertilizerCommodityDiammoniumPhosphate2.FertilizerCommodityDiammoniumPhosphate2Builder dmmnmPhspht;
		protected FertilizerCommodityPotash2.FertilizerCommodityPotash2Builder ptsh;
		protected FertilizerCommoditySulphur2.FertilizerCommoditySulphur2Builder slphr;
		protected FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder urea;
		protected FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder ureaAndAmmnmNtrt;
		protected FertilizerCommodityOther2.FertilizerCommodityOther2Builder othr;
		
		@Override
		@RosettaAttribute("ammn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ammn")
		public FertilizerCommodityAmmonia2.FertilizerCommodityAmmonia2Builder getAmmn() {
			return ammn;
		}
		
		@Override
		public FertilizerCommodityAmmonia2.FertilizerCommodityAmmonia2Builder getOrCreateAmmn() {
			FertilizerCommodityAmmonia2.FertilizerCommodityAmmonia2Builder result;
			if (ammn!=null) {
				result = ammn;
			}
			else {
				result = ammn = FertilizerCommodityAmmonia2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("dmmnmPhspht")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dmmnmPhspht")
		public FertilizerCommodityDiammoniumPhosphate2.FertilizerCommodityDiammoniumPhosphate2Builder getDmmnmPhspht() {
			return dmmnmPhspht;
		}
		
		@Override
		public FertilizerCommodityDiammoniumPhosphate2.FertilizerCommodityDiammoniumPhosphate2Builder getOrCreateDmmnmPhspht() {
			FertilizerCommodityDiammoniumPhosphate2.FertilizerCommodityDiammoniumPhosphate2Builder result;
			if (dmmnmPhspht!=null) {
				result = dmmnmPhspht;
			}
			else {
				result = dmmnmPhspht = FertilizerCommodityDiammoniumPhosphate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ptsh")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ptsh")
		public FertilizerCommodityPotash2.FertilizerCommodityPotash2Builder getPtsh() {
			return ptsh;
		}
		
		@Override
		public FertilizerCommodityPotash2.FertilizerCommodityPotash2Builder getOrCreatePtsh() {
			FertilizerCommodityPotash2.FertilizerCommodityPotash2Builder result;
			if (ptsh!=null) {
				result = ptsh;
			}
			else {
				result = ptsh = FertilizerCommodityPotash2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("slphr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("slphr")
		public FertilizerCommoditySulphur2.FertilizerCommoditySulphur2Builder getSlphr() {
			return slphr;
		}
		
		@Override
		public FertilizerCommoditySulphur2.FertilizerCommoditySulphur2Builder getOrCreateSlphr() {
			FertilizerCommoditySulphur2.FertilizerCommoditySulphur2Builder result;
			if (slphr!=null) {
				result = slphr;
			}
			else {
				result = slphr = FertilizerCommoditySulphur2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("urea")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("urea")
		public FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder getUrea() {
			return urea;
		}
		
		@Override
		public FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder getOrCreateUrea() {
			FertilizerCommodityUrea2.FertilizerCommodityUrea2Builder result;
			if (urea!=null) {
				result = urea;
			}
			else {
				result = urea = FertilizerCommodityUrea2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("ureaAndAmmnmNtrt")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ureaAndAmmnmNtrt")
		public FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder getUreaAndAmmnmNtrt() {
			return ureaAndAmmnmNtrt;
		}
		
		@Override
		public FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder getOrCreateUreaAndAmmnmNtrt() {
			FertilizerCommodityUreaAndAmmoniumNitrate2.FertilizerCommodityUreaAndAmmoniumNitrate2Builder result;
			if (ureaAndAmmnmNtrt!=null) {
				result = ureaAndAmmnmNtrt;
			}
			else {
				result = ureaAndAmmnmNtrt = FertilizerCommodityUreaAndAmmoniumNitrate2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("othr")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("othr")
		public FertilizerCommodityOther2.FertilizerCommodityOther2Builder getOthr() {
			return othr;
		}
		
		@Override
		public FertilizerCommodityOther2.FertilizerCommodityOther2Builder getOrCreateOthr() {
			FertilizerCommodityOther2.FertilizerCommodityOther2Builder result;
			if (othr!=null) {
				result = othr;
			}
			else {
				result = othr = FertilizerCommodityOther2.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("ammn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ammn")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setAmmn(FertilizerCommodityAmmonia2 _ammn) {
			this.ammn = _ammn == null ? null : _ammn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("dmmnmPhspht")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dmmnmPhspht")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setDmmnmPhspht(FertilizerCommodityDiammoniumPhosphate2 _dmmnmPhspht) {
			this.dmmnmPhspht = _dmmnmPhspht == null ? null : _dmmnmPhspht.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ptsh")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ptsh")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setPtsh(FertilizerCommodityPotash2 _ptsh) {
			this.ptsh = _ptsh == null ? null : _ptsh.toBuilder();
			return this;
		}
		
		@RosettaAttribute("slphr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("slphr")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setSlphr(FertilizerCommoditySulphur2 _slphr) {
			this.slphr = _slphr == null ? null : _slphr.toBuilder();
			return this;
		}
		
		@RosettaAttribute("urea")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("urea")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setUrea(FertilizerCommodityUrea2 _urea) {
			this.urea = _urea == null ? null : _urea.toBuilder();
			return this;
		}
		
		@RosettaAttribute("ureaAndAmmnmNtrt")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ureaAndAmmnmNtrt")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setUreaAndAmmnmNtrt(FertilizerCommodityUreaAndAmmoniumNitrate2 _ureaAndAmmnmNtrt) {
			this.ureaAndAmmnmNtrt = _ureaAndAmmnmNtrt == null ? null : _ureaAndAmmnmNtrt.toBuilder();
			return this;
		}
		
		@RosettaAttribute("othr")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("othr")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder setOthr(FertilizerCommodityOther2 _othr) {
			this.othr = _othr == null ? null : _othr.toBuilder();
			return this;
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice build() {
			return new AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceImpl(this);
		}
		
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder prune() {
			if (ammn!=null && !ammn.prune().hasData()) ammn = null;
			if (dmmnmPhspht!=null && !dmmnmPhspht.prune().hasData()) dmmnmPhspht = null;
			if (ptsh!=null && !ptsh.prune().hasData()) ptsh = null;
			if (slphr!=null && !slphr.prune().hasData()) slphr = null;
			if (urea!=null && !urea.prune().hasData()) urea = null;
			if (ureaAndAmmnmNtrt!=null && !ureaAndAmmnmNtrt.prune().hasData()) ureaAndAmmnmNtrt = null;
			if (othr!=null && !othr.prune().hasData()) othr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmmn()!=null && getAmmn().hasData()) return true;
			if (getDmmnmPhspht()!=null && getDmmnmPhspht().hasData()) return true;
			if (getPtsh()!=null && getPtsh().hasData()) return true;
			if (getSlphr()!=null && getSlphr().hasData()) return true;
			if (getUrea()!=null && getUrea().hasData()) return true;
			if (getUreaAndAmmnmNtrt()!=null && getUreaAndAmmnmNtrt().hasData()) return true;
			if (getOthr()!=null && getOthr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder o = (AssetClassCommodityFertilizer4Choice.AssetClassCommodityFertilizer4ChoiceBuilder) other;
			
			merger.mergeRosetta(getAmmn(), o.getAmmn(), this::setAmmn);
			merger.mergeRosetta(getDmmnmPhspht(), o.getDmmnmPhspht(), this::setDmmnmPhspht);
			merger.mergeRosetta(getPtsh(), o.getPtsh(), this::setPtsh);
			merger.mergeRosetta(getSlphr(), o.getSlphr(), this::setSlphr);
			merger.mergeRosetta(getUrea(), o.getUrea(), this::setUrea);
			merger.mergeRosetta(getUreaAndAmmnmNtrt(), o.getUreaAndAmmnmNtrt(), this::setUreaAndAmmnmNtrt);
			merger.mergeRosetta(getOthr(), o.getOthr(), this::setOthr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetClassCommodityFertilizer4Choice _that = getType().cast(o);
		
			if (!Objects.equals(ammn, _that.getAmmn())) return false;
			if (!Objects.equals(dmmnmPhspht, _that.getDmmnmPhspht())) return false;
			if (!Objects.equals(ptsh, _that.getPtsh())) return false;
			if (!Objects.equals(slphr, _that.getSlphr())) return false;
			if (!Objects.equals(urea, _that.getUrea())) return false;
			if (!Objects.equals(ureaAndAmmnmNtrt, _that.getUreaAndAmmnmNtrt())) return false;
			if (!Objects.equals(othr, _that.getOthr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ammn != null ? ammn.hashCode() : 0);
			_result = 31 * _result + (dmmnmPhspht != null ? dmmnmPhspht.hashCode() : 0);
			_result = 31 * _result + (ptsh != null ? ptsh.hashCode() : 0);
			_result = 31 * _result + (slphr != null ? slphr.hashCode() : 0);
			_result = 31 * _result + (urea != null ? urea.hashCode() : 0);
			_result = 31 * _result + (ureaAndAmmnmNtrt != null ? ureaAndAmmnmNtrt.hashCode() : 0);
			_result = 31 * _result + (othr != null ? othr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetClassCommodityFertilizer4ChoiceBuilder {" +
				"ammn=" + this.ammn + ", " +
				"dmmnmPhspht=" + this.dmmnmPhspht + ", " +
				"ptsh=" + this.ptsh + ", " +
				"slphr=" + this.slphr + ", " +
				"urea=" + this.urea + ", " +
				"ureaAndAmmnmNtrt=" + this.ureaAndAmmnmNtrt + ", " +
				"othr=" + this.othr +
			'}';
		}
	}
}
