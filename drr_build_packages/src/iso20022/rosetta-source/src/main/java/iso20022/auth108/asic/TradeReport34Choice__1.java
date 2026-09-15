package iso20022.auth108.asic;

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
import iso20022.auth108.asic.meta.TradeReport34Choice__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeReport34Choice__1", builder=TradeReport34Choice__1.TradeReport34Choice__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TradeReport34Choice__1", model="iso20022", builder=TradeReport34Choice__1.TradeReport34Choice__1BuilderImpl.class, version="${project.version}")
public interface TradeReport34Choice__1 extends RosettaModelObject {

	TradeReport34Choice__1Meta metaData = new TradeReport34Choice__1Meta();

	/*********************** Getter Methods  ***********************/
	MarginReportData9__1 getMrgnUpd();
	MarginReportData9__1 getCrrctn();

	/*********************** Build Methods  ***********************/
	TradeReport34Choice__1 build();
	
	TradeReport34Choice__1.TradeReport34Choice__1Builder toBuilder();
	
	static TradeReport34Choice__1.TradeReport34Choice__1Builder builder() {
		return new TradeReport34Choice__1.TradeReport34Choice__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeReport34Choice__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TradeReport34Choice__1> getType() {
		return TradeReport34Choice__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mrgnUpd"), processor, MarginReportData9__1.class, getMrgnUpd());
		processRosetta(path.newSubPath("crrctn"), processor, MarginReportData9__1.class, getCrrctn());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeReport34Choice__1Builder extends TradeReport34Choice__1, RosettaModelObjectBuilder {
		MarginReportData9__1.MarginReportData9__1Builder getOrCreateMrgnUpd();
		@Override
		MarginReportData9__1.MarginReportData9__1Builder getMrgnUpd();
		MarginReportData9__1.MarginReportData9__1Builder getOrCreateCrrctn();
		@Override
		MarginReportData9__1.MarginReportData9__1Builder getCrrctn();
		TradeReport34Choice__1.TradeReport34Choice__1Builder setMrgnUpd(MarginReportData9__1 mrgnUpd);
		TradeReport34Choice__1.TradeReport34Choice__1Builder setCrrctn(MarginReportData9__1 crrctn);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mrgnUpd"), processor, MarginReportData9__1.MarginReportData9__1Builder.class, getMrgnUpd());
			processRosetta(path.newSubPath("crrctn"), processor, MarginReportData9__1.MarginReportData9__1Builder.class, getCrrctn());
		}
		

		TradeReport34Choice__1.TradeReport34Choice__1Builder prune();
	}

	/*********************** Immutable Implementation of TradeReport34Choice__1  ***********************/
	class TradeReport34Choice__1Impl implements TradeReport34Choice__1 {
		private final MarginReportData9__1 mrgnUpd;
		private final MarginReportData9__1 crrctn;
		
		protected TradeReport34Choice__1Impl(TradeReport34Choice__1.TradeReport34Choice__1Builder builder) {
			this.mrgnUpd = ofNullable(builder.getMrgnUpd()).map(f->f.build()).orElse(null);
			this.crrctn = ofNullable(builder.getCrrctn()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mrgnUpd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mrgnUpd")
		public MarginReportData9__1 getMrgnUpd() {
			return mrgnUpd;
		}
		
		@Override
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crrctn")
		public MarginReportData9__1 getCrrctn() {
			return crrctn;
		}
		
		@Override
		public TradeReport34Choice__1 build() {
			return this;
		}
		
		@Override
		public TradeReport34Choice__1.TradeReport34Choice__1Builder toBuilder() {
			TradeReport34Choice__1.TradeReport34Choice__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeReport34Choice__1.TradeReport34Choice__1Builder builder) {
			ofNullable(getMrgnUpd()).ifPresent(builder::setMrgnUpd);
			ofNullable(getCrrctn()).ifPresent(builder::setCrrctn);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReport34Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(mrgnUpd, _that.getMrgnUpd())) return false;
			if (!Objects.equals(crrctn, _that.getCrrctn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mrgnUpd != null ? mrgnUpd.hashCode() : 0);
			_result = 31 * _result + (crrctn != null ? crrctn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReport34Choice__1 {" +
				"mrgnUpd=" + this.mrgnUpd + ", " +
				"crrctn=" + this.crrctn +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeReport34Choice__1  ***********************/
	class TradeReport34Choice__1BuilderImpl implements TradeReport34Choice__1.TradeReport34Choice__1Builder {
	
		protected MarginReportData9__1.MarginReportData9__1Builder mrgnUpd;
		protected MarginReportData9__1.MarginReportData9__1Builder crrctn;
		
		@Override
		@RosettaAttribute("mrgnUpd")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mrgnUpd")
		public MarginReportData9__1.MarginReportData9__1Builder getMrgnUpd() {
			return mrgnUpd;
		}
		
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder getOrCreateMrgnUpd() {
			MarginReportData9__1.MarginReportData9__1Builder result;
			if (mrgnUpd!=null) {
				result = mrgnUpd;
			}
			else {
				result = mrgnUpd = MarginReportData9__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("crrctn")
		public MarginReportData9__1.MarginReportData9__1Builder getCrrctn() {
			return crrctn;
		}
		
		@Override
		public MarginReportData9__1.MarginReportData9__1Builder getOrCreateCrrctn() {
			MarginReportData9__1.MarginReportData9__1Builder result;
			if (crrctn!=null) {
				result = crrctn;
			}
			else {
				result = crrctn = MarginReportData9__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("mrgnUpd")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mrgnUpd")
		@Override
		public TradeReport34Choice__1.TradeReport34Choice__1Builder setMrgnUpd(MarginReportData9__1 _mrgnUpd) {
			this.mrgnUpd = _mrgnUpd == null ? null : _mrgnUpd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("crrctn")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("crrctn")
		@Override
		public TradeReport34Choice__1.TradeReport34Choice__1Builder setCrrctn(MarginReportData9__1 _crrctn) {
			this.crrctn = _crrctn == null ? null : _crrctn.toBuilder();
			return this;
		}
		
		@Override
		public TradeReport34Choice__1 build() {
			return new TradeReport34Choice__1.TradeReport34Choice__1Impl(this);
		}
		
		@Override
		public TradeReport34Choice__1.TradeReport34Choice__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReport34Choice__1.TradeReport34Choice__1Builder prune() {
			if (mrgnUpd!=null && !mrgnUpd.prune().hasData()) mrgnUpd = null;
			if (crrctn!=null && !crrctn.prune().hasData()) crrctn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMrgnUpd()!=null && getMrgnUpd().hasData()) return true;
			if (getCrrctn()!=null && getCrrctn().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeReport34Choice__1.TradeReport34Choice__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeReport34Choice__1.TradeReport34Choice__1Builder o = (TradeReport34Choice__1.TradeReport34Choice__1Builder) other;
			
			merger.mergeRosetta(getMrgnUpd(), o.getMrgnUpd(), this::setMrgnUpd);
			merger.mergeRosetta(getCrrctn(), o.getCrrctn(), this::setCrrctn);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeReport34Choice__1 _that = getType().cast(o);
		
			if (!Objects.equals(mrgnUpd, _that.getMrgnUpd())) return false;
			if (!Objects.equals(crrctn, _that.getCrrctn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mrgnUpd != null ? mrgnUpd.hashCode() : 0);
			_result = 31 * _result + (crrctn != null ? crrctn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeReport34Choice__1Builder {" +
				"mrgnUpd=" + this.mrgnUpd + ", " +
				"crrctn=" + this.crrctn +
			'}';
		}
	}
}
