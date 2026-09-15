package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.TradeReport31ChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Provides details on the reported trade transactions.
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReport31Choice", builder=TradeReport31Choice.TradeReport31ChoiceBuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeReport31Choice", model="iso20022", builder=TradeReport31Choice.TradeReport31ChoiceBuilderImpl.class, version="${project.version}")
public interface TradeReport31Choice extends RosettaModelObject {

	TradeReport31ChoiceMeta metaData = new TradeReport31ChoiceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates whether transaction is reported for the first time.
	 */
	MarginReportData7 getNew();
	/**
	 * Indicates the report of the collateral data or of their modifications, but not the corrections of the previously reported collateral details.
	 */
	MarginReportData7 getMrgnUpd();
	/**
	 * Indicates whether transaction was reported by mistake and need to be removed.
	 */
	MarginReportData7 getErr();
	/**
	 * Indicates that the report is correcting the erroneous data fields of a previously submitted position.
	 */
	MarginReportData7 getCrrctn();

	/*********************** Build Methods  ***********************/
	TradeReport31Choice build();
	
	TradeReport31Choice.TradeReport31ChoiceBuilder toBuilder();
	
	static TradeReport31Choice.TradeReport31ChoiceBuilder builder() {
		return new TradeReport31Choice.TradeReport31ChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReport31Choice> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeReport31Choice> getType() {
		return TradeReport31Choice.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("new"), processor, MarginReportData7.class, getNew());
		processRosetta(path.newSubPath("mrgnUpd"), processor, MarginReportData7.class, getMrgnUpd());
		processRosetta(path.newSubPath("err"), processor, MarginReportData7.class, getErr());
		processRosetta(path.newSubPath("crrctn"), processor, MarginReportData7.class, getCrrctn());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReport31ChoiceBuilder extends TradeReport31Choice, RosettaModelObjectBuilder {
		MarginReportData7.MarginReportData7Builder getOrCreateNew();
		@Override
		MarginReportData7.MarginReportData7Builder getNew();
		MarginReportData7.MarginReportData7Builder getOrCreateMrgnUpd();
		@Override
		MarginReportData7.MarginReportData7Builder getMrgnUpd();
		MarginReportData7.MarginReportData7Builder getOrCreateErr();
		@Override
		MarginReportData7.MarginReportData7Builder getErr();
		MarginReportData7.MarginReportData7Builder getOrCreateCrrctn();
		@Override
		MarginReportData7.MarginReportData7Builder getCrrctn();
		TradeReport31Choice.TradeReport31ChoiceBuilder setNew(MarginReportData7 _new);
		TradeReport31Choice.TradeReport31ChoiceBuilder setMrgnUpd(MarginReportData7 mrgnUpd);
		TradeReport31Choice.TradeReport31ChoiceBuilder setErr(MarginReportData7 err);
		TradeReport31Choice.TradeReport31ChoiceBuilder setCrrctn(MarginReportData7 crrctn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("new"), processor, MarginReportData7.MarginReportData7Builder.class, getNew());
			processRosetta(path.newSubPath("mrgnUpd"), processor, MarginReportData7.MarginReportData7Builder.class, getMrgnUpd());
			processRosetta(path.newSubPath("err"), processor, MarginReportData7.MarginReportData7Builder.class, getErr());
			processRosetta(path.newSubPath("crrctn"), processor, MarginReportData7.MarginReportData7Builder.class, getCrrctn());
		}
		

		TradeReport31Choice.TradeReport31ChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of TradeReport31Choice  ***********************/
	class TradeReport31ChoiceImpl implements TradeReport31Choice {
		private final MarginReportData7 _new;
		private final MarginReportData7 mrgnUpd;
		private final MarginReportData7 err;
		private final MarginReportData7 crrctn;
		
		protected TradeReport31ChoiceImpl(TradeReport31Choice.TradeReport31ChoiceBuilder builder) {
			this._new = ofNullable(builder.getNew()).map(f->f.build()).orElse(null);
			this.mrgnUpd = ofNullable(builder.getMrgnUpd()).map(f->f.build()).orElse(null);
			this.err = ofNullable(builder.getErr()).map(f->f.build()).orElse(null);
			this.crrctn = ofNullable(builder.getCrrctn()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("new")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("new")
		public MarginReportData7 getNew() {
			return _new;
		}
		
		@Override
		@RosettaAttribute("mrgnUpd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mrgnUpd")
		public MarginReportData7 getMrgnUpd() {
			return mrgnUpd;
		}
		
		@Override
		@RosettaAttribute("err")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("err")
		public MarginReportData7 getErr() {
			return err;
		}
		
		@Override
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crrctn")
		public MarginReportData7 getCrrctn() {
			return crrctn;
		}
		
		@Override
		public TradeReport31Choice build() {
			return this;
		}
		
		@Override
		public TradeReport31Choice.TradeReport31ChoiceBuilder toBuilder() {
			TradeReport31Choice.TradeReport31ChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReport31Choice.TradeReport31ChoiceBuilder builder) {
			ofNullable(getNew()).ifPresent(builder::setNew);
			ofNullable(getMrgnUpd()).ifPresent(builder::setMrgnUpd);
			ofNullable(getErr()).ifPresent(builder::setErr);
			ofNullable(getCrrctn()).ifPresent(builder::setCrrctn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReport31Choice _that = getType().cast(o);
		
			if (!Objects.equals(_new, _that.getNew())) return false;
			if (!Objects.equals(mrgnUpd, _that.getMrgnUpd())) return false;
			if (!Objects.equals(err, _that.getErr())) return false;
			if (!Objects.equals(crrctn, _that.getCrrctn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_new != null ? _new.hashCode() : 0);
			_result = 31 * _result + (mrgnUpd != null ? mrgnUpd.hashCode() : 0);
			_result = 31 * _result + (err != null ? err.hashCode() : 0);
			_result = 31 * _result + (crrctn != null ? crrctn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReport31Choice {" +
				"new=" + this._new + ", " +
				"mrgnUpd=" + this.mrgnUpd + ", " +
				"err=" + this.err + ", " +
				"crrctn=" + this.crrctn +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReport31Choice  ***********************/
	class TradeReport31ChoiceBuilderImpl implements TradeReport31Choice.TradeReport31ChoiceBuilder {
	
		protected MarginReportData7.MarginReportData7Builder _new;
		protected MarginReportData7.MarginReportData7Builder mrgnUpd;
		protected MarginReportData7.MarginReportData7Builder err;
		protected MarginReportData7.MarginReportData7Builder crrctn;
		
		@Override
		@RosettaAttribute("new")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("new")
		public MarginReportData7.MarginReportData7Builder getNew() {
			return _new;
		}
		
		@Override
		public MarginReportData7.MarginReportData7Builder getOrCreateNew() {
			MarginReportData7.MarginReportData7Builder result;
			if (_new!=null) {
				result = _new;
			}
			else {
				result = _new = MarginReportData7.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("mrgnUpd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mrgnUpd")
		public MarginReportData7.MarginReportData7Builder getMrgnUpd() {
			return mrgnUpd;
		}
		
		@Override
		public MarginReportData7.MarginReportData7Builder getOrCreateMrgnUpd() {
			MarginReportData7.MarginReportData7Builder result;
			if (mrgnUpd!=null) {
				result = mrgnUpd;
			}
			else {
				result = mrgnUpd = MarginReportData7.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("err")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("err")
		public MarginReportData7.MarginReportData7Builder getErr() {
			return err;
		}
		
		@Override
		public MarginReportData7.MarginReportData7Builder getOrCreateErr() {
			MarginReportData7.MarginReportData7Builder result;
			if (err!=null) {
				result = err;
			}
			else {
				result = err = MarginReportData7.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crrctn")
		public MarginReportData7.MarginReportData7Builder getCrrctn() {
			return crrctn;
		}
		
		@Override
		public MarginReportData7.MarginReportData7Builder getOrCreateCrrctn() {
			MarginReportData7.MarginReportData7Builder result;
			if (crrctn!=null) {
				result = crrctn;
			}
			else {
				result = crrctn = MarginReportData7.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("new")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("new")
		@Override
		public TradeReport31Choice.TradeReport31ChoiceBuilder setNew(MarginReportData7 __new) {
			this._new = __new == null ? null : __new.toBuilder();
			return this;
		}
		
		@RosettaAttribute("mrgnUpd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mrgnUpd")
		@Override
		public TradeReport31Choice.TradeReport31ChoiceBuilder setMrgnUpd(MarginReportData7 _mrgnUpd) {
			this.mrgnUpd = _mrgnUpd == null ? null : _mrgnUpd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("err")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("err")
		@Override
		public TradeReport31Choice.TradeReport31ChoiceBuilder setErr(MarginReportData7 _err) {
			this.err = _err == null ? null : _err.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("crrctn")
		@Override
		public TradeReport31Choice.TradeReport31ChoiceBuilder setCrrctn(MarginReportData7 _crrctn) {
			this.crrctn = _crrctn == null ? null : _crrctn.toBuilder();
			return this;
		}
		
		@Override
		public TradeReport31Choice build() {
			return new TradeReport31Choice.TradeReport31ChoiceImpl(this);
		}
		
		@Override
		public TradeReport31Choice.TradeReport31ChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReport31Choice.TradeReport31ChoiceBuilder prune() {
			if (_new!=null && !_new.prune().hasData()) _new = null;
			if (mrgnUpd!=null && !mrgnUpd.prune().hasData()) mrgnUpd = null;
			if (err!=null && !err.prune().hasData()) err = null;
			if (crrctn!=null && !crrctn.prune().hasData()) crrctn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNew()!=null && getNew().hasData()) return true;
			if (getMrgnUpd()!=null && getMrgnUpd().hasData()) return true;
			if (getErr()!=null && getErr().hasData()) return true;
			if (getCrrctn()!=null && getCrrctn().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReport31Choice.TradeReport31ChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReport31Choice.TradeReport31ChoiceBuilder o = (TradeReport31Choice.TradeReport31ChoiceBuilder) other;
			
			merger.mergeRosetta(getNew(), o.getNew(), this::setNew);
			merger.mergeRosetta(getMrgnUpd(), o.getMrgnUpd(), this::setMrgnUpd);
			merger.mergeRosetta(getErr(), o.getErr(), this::setErr);
			merger.mergeRosetta(getCrrctn(), o.getCrrctn(), this::setCrrctn);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReport31Choice _that = getType().cast(o);
		
			if (!Objects.equals(_new, _that.getNew())) return false;
			if (!Objects.equals(mrgnUpd, _that.getMrgnUpd())) return false;
			if (!Objects.equals(err, _that.getErr())) return false;
			if (!Objects.equals(crrctn, _that.getCrrctn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_new != null ? _new.hashCode() : 0);
			_result = 31 * _result + (mrgnUpd != null ? mrgnUpd.hashCode() : 0);
			_result = 31 * _result + (err != null ? err.hashCode() : 0);
			_result = 31 * _result + (crrctn != null ? crrctn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReport31ChoiceBuilder {" +
				"new=" + this._new + ", " +
				"mrgnUpd=" + this.mrgnUpd + ", " +
				"err=" + this.err + ", " +
				"crrctn=" + this.crrctn +
			'}';
		}
	}
}
