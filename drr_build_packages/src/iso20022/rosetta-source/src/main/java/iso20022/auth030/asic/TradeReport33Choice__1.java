package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.TradeReport33Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReport33Choice__1", builder=TradeReport33Choice__1.TradeReport33Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeReport33Choice__1", model="iso20022", builder=TradeReport33Choice__1.TradeReport33Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeReport33Choice__1 extends RosettaModelObject {

	TradeReport33Choice__1Meta metaData = new TradeReport33Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	TradeData43__1 getNew();
	TradeData43__2 getMod();
	TradeData43__3 getCrrctn();
	TradeData43__4 getTermntn();
	TradeData43__5 getValtnUpd();
	TradeData43__6 getErr();
	TradeData43__7 getPortOut();
	TradeData43__3 getRvv();

	/*********************** Build Methods  ***********************/
	TradeReport33Choice__1 build();
	
	TradeReport33Choice__1.TradeReport33Choice__1Builder toBuilder();
	
	static TradeReport33Choice__1.TradeReport33Choice__1Builder builder() {
		return new TradeReport33Choice__1.TradeReport33Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReport33Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeReport33Choice__1> getType() {
		return TradeReport33Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("new"), processor, TradeData43__1.class, getNew());
		processRosetta(path.newSubPath("mod"), processor, TradeData43__2.class, getMod());
		processRosetta(path.newSubPath("crrctn"), processor, TradeData43__3.class, getCrrctn());
		processRosetta(path.newSubPath("termntn"), processor, TradeData43__4.class, getTermntn());
		processRosetta(path.newSubPath("valtnUpd"), processor, TradeData43__5.class, getValtnUpd());
		processRosetta(path.newSubPath("err"), processor, TradeData43__6.class, getErr());
		processRosetta(path.newSubPath("portOut"), processor, TradeData43__7.class, getPortOut());
		processRosetta(path.newSubPath("rvv"), processor, TradeData43__3.class, getRvv());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReport33Choice__1Builder extends TradeReport33Choice__1, RosettaModelObjectBuilder {
		TradeData43__1.TradeData43__1Builder getOrCreateNew();
		@Override
		TradeData43__1.TradeData43__1Builder getNew();
		TradeData43__2.TradeData43__2Builder getOrCreateMod();
		@Override
		TradeData43__2.TradeData43__2Builder getMod();
		TradeData43__3.TradeData43__3Builder getOrCreateCrrctn();
		@Override
		TradeData43__3.TradeData43__3Builder getCrrctn();
		TradeData43__4.TradeData43__4Builder getOrCreateTermntn();
		@Override
		TradeData43__4.TradeData43__4Builder getTermntn();
		TradeData43__5.TradeData43__5Builder getOrCreateValtnUpd();
		@Override
		TradeData43__5.TradeData43__5Builder getValtnUpd();
		TradeData43__6.TradeData43__6Builder getOrCreateErr();
		@Override
		TradeData43__6.TradeData43__6Builder getErr();
		TradeData43__7.TradeData43__7Builder getOrCreatePortOut();
		@Override
		TradeData43__7.TradeData43__7Builder getPortOut();
		TradeData43__3.TradeData43__3Builder getOrCreateRvv();
		@Override
		TradeData43__3.TradeData43__3Builder getRvv();
		TradeReport33Choice__1.TradeReport33Choice__1Builder setNew(TradeData43__1 _new);
		TradeReport33Choice__1.TradeReport33Choice__1Builder setMod(TradeData43__2 mod);
		TradeReport33Choice__1.TradeReport33Choice__1Builder setCrrctn(TradeData43__3 crrctn);
		TradeReport33Choice__1.TradeReport33Choice__1Builder setTermntn(TradeData43__4 termntn);
		TradeReport33Choice__1.TradeReport33Choice__1Builder setValtnUpd(TradeData43__5 valtnUpd);
		TradeReport33Choice__1.TradeReport33Choice__1Builder setErr(TradeData43__6 err);
		TradeReport33Choice__1.TradeReport33Choice__1Builder setPortOut(TradeData43__7 portOut);
		TradeReport33Choice__1.TradeReport33Choice__1Builder setRvv(TradeData43__3 rvv);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("new"), processor, TradeData43__1.TradeData43__1Builder.class, getNew());
			processRosetta(path.newSubPath("mod"), processor, TradeData43__2.TradeData43__2Builder.class, getMod());
			processRosetta(path.newSubPath("crrctn"), processor, TradeData43__3.TradeData43__3Builder.class, getCrrctn());
			processRosetta(path.newSubPath("termntn"), processor, TradeData43__4.TradeData43__4Builder.class, getTermntn());
			processRosetta(path.newSubPath("valtnUpd"), processor, TradeData43__5.TradeData43__5Builder.class, getValtnUpd());
			processRosetta(path.newSubPath("err"), processor, TradeData43__6.TradeData43__6Builder.class, getErr());
			processRosetta(path.newSubPath("portOut"), processor, TradeData43__7.TradeData43__7Builder.class, getPortOut());
			processRosetta(path.newSubPath("rvv"), processor, TradeData43__3.TradeData43__3Builder.class, getRvv());
		}
		

		TradeReport33Choice__1.TradeReport33Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeReport33Choice__1  ***********************/
	class TradeReport33Choice__1Impl implements TradeReport33Choice__1 {
		private final TradeData43__1 _new;
		private final TradeData43__2 mod;
		private final TradeData43__3 crrctn;
		private final TradeData43__4 termntn;
		private final TradeData43__5 valtnUpd;
		private final TradeData43__6 err;
		private final TradeData43__7 portOut;
		private final TradeData43__3 rvv;
		
		protected TradeReport33Choice__1Impl(TradeReport33Choice__1.TradeReport33Choice__1Builder builder) {
			this._new = ofNullable(builder.getNew()).map(f->f.build()).orElse(null);
			this.mod = ofNullable(builder.getMod()).map(f->f.build()).orElse(null);
			this.crrctn = ofNullable(builder.getCrrctn()).map(f->f.build()).orElse(null);
			this.termntn = ofNullable(builder.getTermntn()).map(f->f.build()).orElse(null);
			this.valtnUpd = ofNullable(builder.getValtnUpd()).map(f->f.build()).orElse(null);
			this.err = ofNullable(builder.getErr()).map(f->f.build()).orElse(null);
			this.portOut = ofNullable(builder.getPortOut()).map(f->f.build()).orElse(null);
			this.rvv = ofNullable(builder.getRvv()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("new")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("new")
		public TradeData43__1 getNew() {
			return _new;
		}
		
		@Override
		@RosettaAttribute("mod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mod")
		public TradeData43__2 getMod() {
			return mod;
		}
		
		@Override
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crrctn")
		public TradeData43__3 getCrrctn() {
			return crrctn;
		}
		
		@Override
		@RosettaAttribute("termntn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termntn")
		public TradeData43__4 getTermntn() {
			return termntn;
		}
		
		@Override
		@RosettaAttribute("valtnUpd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valtnUpd")
		public TradeData43__5 getValtnUpd() {
			return valtnUpd;
		}
		
		@Override
		@RosettaAttribute("err")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("err")
		public TradeData43__6 getErr() {
			return err;
		}
		
		@Override
		@RosettaAttribute("portOut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portOut")
		public TradeData43__7 getPortOut() {
			return portOut;
		}
		
		@Override
		@RosettaAttribute("rvv")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rvv")
		public TradeData43__3 getRvv() {
			return rvv;
		}
		
		@Override
		public TradeReport33Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder toBuilder() {
			TradeReport33Choice__1.TradeReport33Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReport33Choice__1.TradeReport33Choice__1Builder builder) {
			ofNullable(getNew()).ifPresent(builder::setNew);
			ofNullable(getMod()).ifPresent(builder::setMod);
			ofNullable(getCrrctn()).ifPresent(builder::setCrrctn);
			ofNullable(getTermntn()).ifPresent(builder::setTermntn);
			ofNullable(getValtnUpd()).ifPresent(builder::setValtnUpd);
			ofNullable(getErr()).ifPresent(builder::setErr);
			ofNullable(getPortOut()).ifPresent(builder::setPortOut);
			ofNullable(getRvv()).ifPresent(builder::setRvv);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReport33Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(_new, _that.getNew())) return false;
			if (!Objects.equals(mod, _that.getMod())) return false;
			if (!Objects.equals(crrctn, _that.getCrrctn())) return false;
			if (!Objects.equals(termntn, _that.getTermntn())) return false;
			if (!Objects.equals(valtnUpd, _that.getValtnUpd())) return false;
			if (!Objects.equals(err, _that.getErr())) return false;
			if (!Objects.equals(portOut, _that.getPortOut())) return false;
			if (!Objects.equals(rvv, _that.getRvv())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_new != null ? _new.hashCode() : 0);
			_result = 31 * _result + (mod != null ? mod.hashCode() : 0);
			_result = 31 * _result + (crrctn != null ? crrctn.hashCode() : 0);
			_result = 31 * _result + (termntn != null ? termntn.hashCode() : 0);
			_result = 31 * _result + (valtnUpd != null ? valtnUpd.hashCode() : 0);
			_result = 31 * _result + (err != null ? err.hashCode() : 0);
			_result = 31 * _result + (portOut != null ? portOut.hashCode() : 0);
			_result = 31 * _result + (rvv != null ? rvv.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReport33Choice__1 {" +
				"new=" + this._new + ", " +
				"mod=" + this.mod + ", " +
				"crrctn=" + this.crrctn + ", " +
				"termntn=" + this.termntn + ", " +
				"valtnUpd=" + this.valtnUpd + ", " +
				"err=" + this.err + ", " +
				"portOut=" + this.portOut + ", " +
				"rvv=" + this.rvv +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReport33Choice__1  ***********************/
	class TradeReport33Choice__1BuilderImpl implements TradeReport33Choice__1.TradeReport33Choice__1Builder {
	
		protected TradeData43__1.TradeData43__1Builder _new;
		protected TradeData43__2.TradeData43__2Builder mod;
		protected TradeData43__3.TradeData43__3Builder crrctn;
		protected TradeData43__4.TradeData43__4Builder termntn;
		protected TradeData43__5.TradeData43__5Builder valtnUpd;
		protected TradeData43__6.TradeData43__6Builder err;
		protected TradeData43__7.TradeData43__7Builder portOut;
		protected TradeData43__3.TradeData43__3Builder rvv;
		
		@Override
		@RosettaAttribute("new")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("new")
		public TradeData43__1.TradeData43__1Builder getNew() {
			return _new;
		}
		
		@Override
		public TradeData43__1.TradeData43__1Builder getOrCreateNew() {
			TradeData43__1.TradeData43__1Builder result;
			if (_new!=null) {
				result = _new;
			}
			else {
				result = _new = TradeData43__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mod")
		public TradeData43__2.TradeData43__2Builder getMod() {
			return mod;
		}
		
		@Override
		public TradeData43__2.TradeData43__2Builder getOrCreateMod() {
			TradeData43__2.TradeData43__2Builder result;
			if (mod!=null) {
				result = mod;
			}
			else {
				result = mod = TradeData43__2.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crrctn")
		public TradeData43__3.TradeData43__3Builder getCrrctn() {
			return crrctn;
		}
		
		@Override
		public TradeData43__3.TradeData43__3Builder getOrCreateCrrctn() {
			TradeData43__3.TradeData43__3Builder result;
			if (crrctn!=null) {
				result = crrctn;
			}
			else {
				result = crrctn = TradeData43__3.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("termntn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termntn")
		public TradeData43__4.TradeData43__4Builder getTermntn() {
			return termntn;
		}
		
		@Override
		public TradeData43__4.TradeData43__4Builder getOrCreateTermntn() {
			TradeData43__4.TradeData43__4Builder result;
			if (termntn!=null) {
				result = termntn;
			}
			else {
				result = termntn = TradeData43__4.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valtnUpd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valtnUpd")
		public TradeData43__5.TradeData43__5Builder getValtnUpd() {
			return valtnUpd;
		}
		
		@Override
		public TradeData43__5.TradeData43__5Builder getOrCreateValtnUpd() {
			TradeData43__5.TradeData43__5Builder result;
			if (valtnUpd!=null) {
				result = valtnUpd;
			}
			else {
				result = valtnUpd = TradeData43__5.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("err")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("err")
		public TradeData43__6.TradeData43__6Builder getErr() {
			return err;
		}
		
		@Override
		public TradeData43__6.TradeData43__6Builder getOrCreateErr() {
			TradeData43__6.TradeData43__6Builder result;
			if (err!=null) {
				result = err;
			}
			else {
				result = err = TradeData43__6.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portOut")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portOut")
		public TradeData43__7.TradeData43__7Builder getPortOut() {
			return portOut;
		}
		
		@Override
		public TradeData43__7.TradeData43__7Builder getOrCreatePortOut() {
			TradeData43__7.TradeData43__7Builder result;
			if (portOut!=null) {
				result = portOut;
			}
			else {
				result = portOut = TradeData43__7.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("rvv")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rvv")
		public TradeData43__3.TradeData43__3Builder getRvv() {
			return rvv;
		}
		
		@Override
		public TradeData43__3.TradeData43__3Builder getOrCreateRvv() {
			TradeData43__3.TradeData43__3Builder result;
			if (rvv!=null) {
				result = rvv;
			}
			else {
				result = rvv = TradeData43__3.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("new")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("new")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder setNew(TradeData43__1 __new) {
			this._new = __new == null ? null : __new.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mod")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder setMod(TradeData43__2 _mod) {
			this.mod = _mod == null ? null : _mod.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("crrctn")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder setCrrctn(TradeData43__3 _crrctn) {
			this.crrctn = _crrctn == null ? null : _crrctn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termntn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termntn")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder setTermntn(TradeData43__4 _termntn) {
			this.termntn = _termntn == null ? null : _termntn.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valtnUpd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valtnUpd")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder setValtnUpd(TradeData43__5 _valtnUpd) {
			this.valtnUpd = _valtnUpd == null ? null : _valtnUpd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("err")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("err")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder setErr(TradeData43__6 _err) {
			this.err = _err == null ? null : _err.toBuilder();
			return this;
		}
		
		@RosettaAttribute("portOut")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("portOut")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder setPortOut(TradeData43__7 _portOut) {
			this.portOut = _portOut == null ? null : _portOut.toBuilder();
			return this;
		}
		
		@RosettaAttribute("rvv")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rvv")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder setRvv(TradeData43__3 _rvv) {
			this.rvv = _rvv == null ? null : _rvv.toBuilder();
			return this;
		}
		
		@Override
		public TradeReport33Choice__1 build() {
			return new TradeReport33Choice__1.TradeReport33Choice__1Impl(this);
		}
		
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder prune() {
			if (_new!=null && !_new.prune().hasData()) _new = null;
			if (mod!=null && !mod.prune().hasData()) mod = null;
			if (crrctn!=null && !crrctn.prune().hasData()) crrctn = null;
			if (termntn!=null && !termntn.prune().hasData()) termntn = null;
			if (valtnUpd!=null && !valtnUpd.prune().hasData()) valtnUpd = null;
			if (err!=null && !err.prune().hasData()) err = null;
			if (portOut!=null && !portOut.prune().hasData()) portOut = null;
			if (rvv!=null && !rvv.prune().hasData()) rvv = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNew()!=null && getNew().hasData()) return true;
			if (getMod()!=null && getMod().hasData()) return true;
			if (getCrrctn()!=null && getCrrctn().hasData()) return true;
			if (getTermntn()!=null && getTermntn().hasData()) return true;
			if (getValtnUpd()!=null && getValtnUpd().hasData()) return true;
			if (getErr()!=null && getErr().hasData()) return true;
			if (getPortOut()!=null && getPortOut().hasData()) return true;
			if (getRvv()!=null && getRvv().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReport33Choice__1.TradeReport33Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReport33Choice__1.TradeReport33Choice__1Builder o = (TradeReport33Choice__1.TradeReport33Choice__1Builder) other;
			
			merger.mergeRosetta(getNew(), o.getNew(), this::setNew);
			merger.mergeRosetta(getMod(), o.getMod(), this::setMod);
			merger.mergeRosetta(getCrrctn(), o.getCrrctn(), this::setCrrctn);
			merger.mergeRosetta(getTermntn(), o.getTermntn(), this::setTermntn);
			merger.mergeRosetta(getValtnUpd(), o.getValtnUpd(), this::setValtnUpd);
			merger.mergeRosetta(getErr(), o.getErr(), this::setErr);
			merger.mergeRosetta(getPortOut(), o.getPortOut(), this::setPortOut);
			merger.mergeRosetta(getRvv(), o.getRvv(), this::setRvv);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReport33Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(_new, _that.getNew())) return false;
			if (!Objects.equals(mod, _that.getMod())) return false;
			if (!Objects.equals(crrctn, _that.getCrrctn())) return false;
			if (!Objects.equals(termntn, _that.getTermntn())) return false;
			if (!Objects.equals(valtnUpd, _that.getValtnUpd())) return false;
			if (!Objects.equals(err, _that.getErr())) return false;
			if (!Objects.equals(portOut, _that.getPortOut())) return false;
			if (!Objects.equals(rvv, _that.getRvv())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_new != null ? _new.hashCode() : 0);
			_result = 31 * _result + (mod != null ? mod.hashCode() : 0);
			_result = 31 * _result + (crrctn != null ? crrctn.hashCode() : 0);
			_result = 31 * _result + (termntn != null ? termntn.hashCode() : 0);
			_result = 31 * _result + (valtnUpd != null ? valtnUpd.hashCode() : 0);
			_result = 31 * _result + (err != null ? err.hashCode() : 0);
			_result = 31 * _result + (portOut != null ? portOut.hashCode() : 0);
			_result = 31 * _result + (rvv != null ? rvv.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReport33Choice__1Builder {" +
				"new=" + this._new + ", " +
				"mod=" + this.mod + ", " +
				"crrctn=" + this.crrctn + ", " +
				"termntn=" + this.termntn + ", " +
				"valtnUpd=" + this.valtnUpd + ", " +
				"err=" + this.err + ", " +
				"portOut=" + this.portOut + ", " +
				"rvv=" + this.rvv +
			'}';
		}
	}
}
