package iso20022.auth030.asic;

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
import iso20022.auth030.asic.meta.TechnicalAttributes5__1Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TechnicalAttributes5__1", builder=TechnicalAttributes5__1.TechnicalAttributes5__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TechnicalAttributes5__1", model="iso20022", builder=TechnicalAttributes5__1.TechnicalAttributes5__1BuilderImpl.class, version="${project.version}")
public interface TechnicalAttributes5__1 extends RosettaModelObject {

	TechnicalAttributes5__1Meta metaData = new TechnicalAttributes5__1Meta();

	/*********************** Getter Methods  ***********************/
	String getTechRcrdId();
	ZonedDateTime getRptRctTmStmp();

	/*********************** Build Methods  ***********************/
	TechnicalAttributes5__1 build();
	
	TechnicalAttributes5__1.TechnicalAttributes5__1Builder toBuilder();
	
	static TechnicalAttributes5__1.TechnicalAttributes5__1Builder builder() {
		return new TechnicalAttributes5__1.TechnicalAttributes5__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TechnicalAttributes5__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TechnicalAttributes5__1> getType() {
		return TechnicalAttributes5__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("techRcrdId"), String.class, getTechRcrdId(), this);
		processor.processBasic(path.newSubPath("rptRctTmStmp"), ZonedDateTime.class, getRptRctTmStmp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TechnicalAttributes5__1Builder extends TechnicalAttributes5__1, RosettaModelObjectBuilder {
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder setTechRcrdId(String techRcrdId);
		TechnicalAttributes5__1.TechnicalAttributes5__1Builder setRptRctTmStmp(ZonedDateTime rptRctTmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("techRcrdId"), String.class, getTechRcrdId(), this);
			processor.processBasic(path.newSubPath("rptRctTmStmp"), ZonedDateTime.class, getRptRctTmStmp(), this);
		}
		

		TechnicalAttributes5__1.TechnicalAttributes5__1Builder prune();
	}

	/*********************** Immutable Implementation of TechnicalAttributes5__1  ***********************/
	class TechnicalAttributes5__1Impl implements TechnicalAttributes5__1 {
		private final String techRcrdId;
		private final ZonedDateTime rptRctTmStmp;
		
		protected TechnicalAttributes5__1Impl(TechnicalAttributes5__1.TechnicalAttributes5__1Builder builder) {
			this.techRcrdId = builder.getTechRcrdId();
			this.rptRctTmStmp = builder.getRptRctTmStmp();
		}
		
		@Override
		@RosettaAttribute("techRcrdId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("techRcrdId")
		public String getTechRcrdId() {
			return techRcrdId;
		}
		
		@Override
		@RosettaAttribute("rptRctTmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptRctTmStmp")
		public ZonedDateTime getRptRctTmStmp() {
			return rptRctTmStmp;
		}
		
		@Override
		public TechnicalAttributes5__1 build() {
			return this;
		}
		
		@Override
		public TechnicalAttributes5__1.TechnicalAttributes5__1Builder toBuilder() {
			TechnicalAttributes5__1.TechnicalAttributes5__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TechnicalAttributes5__1.TechnicalAttributes5__1Builder builder) {
			ofNullable(getTechRcrdId()).ifPresent(builder::setTechRcrdId);
			ofNullable(getRptRctTmStmp()).ifPresent(builder::setRptRctTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TechnicalAttributes5__1 _that = getType().cast(o);
		
			if (!Objects.equals(techRcrdId, _that.getTechRcrdId())) return false;
			if (!Objects.equals(rptRctTmStmp, _that.getRptRctTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (techRcrdId != null ? techRcrdId.hashCode() : 0);
			_result = 31 * _result + (rptRctTmStmp != null ? rptRctTmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TechnicalAttributes5__1 {" +
				"techRcrdId=" + this.techRcrdId + ", " +
				"rptRctTmStmp=" + this.rptRctTmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of TechnicalAttributes5__1  ***********************/
	class TechnicalAttributes5__1BuilderImpl implements TechnicalAttributes5__1.TechnicalAttributes5__1Builder {
	
		protected String techRcrdId;
		protected ZonedDateTime rptRctTmStmp;
		
		@Override
		@RosettaAttribute("techRcrdId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("techRcrdId")
		public String getTechRcrdId() {
			return techRcrdId;
		}
		
		@Override
		@RosettaAttribute("rptRctTmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rptRctTmStmp")
		public ZonedDateTime getRptRctTmStmp() {
			return rptRctTmStmp;
		}
		
		@RosettaAttribute("techRcrdId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("techRcrdId")
		@Override
		public TechnicalAttributes5__1.TechnicalAttributes5__1Builder setTechRcrdId(String _techRcrdId) {
			this.techRcrdId = _techRcrdId == null ? null : _techRcrdId;
			return this;
		}
		
		@RosettaAttribute("rptRctTmStmp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptRctTmStmp")
		@Override
		public TechnicalAttributes5__1.TechnicalAttributes5__1Builder setRptRctTmStmp(ZonedDateTime _rptRctTmStmp) {
			this.rptRctTmStmp = _rptRctTmStmp == null ? null : _rptRctTmStmp;
			return this;
		}
		
		@Override
		public TechnicalAttributes5__1 build() {
			return new TechnicalAttributes5__1.TechnicalAttributes5__1Impl(this);
		}
		
		@Override
		public TechnicalAttributes5__1.TechnicalAttributes5__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TechnicalAttributes5__1.TechnicalAttributes5__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTechRcrdId()!=null) return true;
			if (getRptRctTmStmp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TechnicalAttributes5__1.TechnicalAttributes5__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TechnicalAttributes5__1.TechnicalAttributes5__1Builder o = (TechnicalAttributes5__1.TechnicalAttributes5__1Builder) other;
			
			
			merger.mergeBasic(getTechRcrdId(), o.getTechRcrdId(), this::setTechRcrdId);
			merger.mergeBasic(getRptRctTmStmp(), o.getRptRctTmStmp(), this::setRptRctTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TechnicalAttributes5__1 _that = getType().cast(o);
		
			if (!Objects.equals(techRcrdId, _that.getTechRcrdId())) return false;
			if (!Objects.equals(rptRctTmStmp, _that.getRptRctTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (techRcrdId != null ? techRcrdId.hashCode() : 0);
			_result = 31 * _result + (rptRctTmStmp != null ? rptRctTmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TechnicalAttributes5__1Builder {" +
				"techRcrdId=" + this.techRcrdId + ", " +
				"rptRctTmStmp=" + this.rptRctTmStmp +
			'}';
		}
	}
}
