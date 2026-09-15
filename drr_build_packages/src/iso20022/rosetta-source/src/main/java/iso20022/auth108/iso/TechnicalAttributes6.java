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
import iso20022.auth108.iso.meta.TechnicalAttributes6Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies technical attributes of the message.
 * @version ${project.version}
 */
@RosettaDataType(value="TechnicalAttributes6", builder=TechnicalAttributes6.TechnicalAttributes6BuilderImpl.class, version="${project.version}")
@RuneDataType(value="TechnicalAttributes6", model="iso20022", builder=TechnicalAttributes6.TechnicalAttributes6BuilderImpl.class, version="${project.version}")
public interface TechnicalAttributes6 extends RosettaModelObject {

	TechnicalAttributes6Meta metaData = new TechnicalAttributes6Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Unique identifier of a record in a message used as part of error management and status advice message.
	 */
	String getTechRcrdId();
	/**
	 * Indicates the date and time of the receipt of the submission of the report to the trade repository as recorded by the trade repository. This item should only be present in a message from the trade repository to an authority and/or other recipients of the message.
	 */
	ZonedDateTime getRptRctTmStmp();

	/*********************** Build Methods  ***********************/
	TechnicalAttributes6 build();
	
	TechnicalAttributes6.TechnicalAttributes6Builder toBuilder();
	
	static TechnicalAttributes6.TechnicalAttributes6Builder builder() {
		return new TechnicalAttributes6.TechnicalAttributes6BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TechnicalAttributes6> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends TechnicalAttributes6> getType() {
		return TechnicalAttributes6.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("techRcrdId"), String.class, getTechRcrdId(), this);
		processor.processBasic(path.newSubPath("rptRctTmStmp"), ZonedDateTime.class, getRptRctTmStmp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TechnicalAttributes6Builder extends TechnicalAttributes6, RosettaModelObjectBuilder {
		TechnicalAttributes6.TechnicalAttributes6Builder setTechRcrdId(String techRcrdId);
		TechnicalAttributes6.TechnicalAttributes6Builder setRptRctTmStmp(ZonedDateTime rptRctTmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("techRcrdId"), String.class, getTechRcrdId(), this);
			processor.processBasic(path.newSubPath("rptRctTmStmp"), ZonedDateTime.class, getRptRctTmStmp(), this);
		}
		

		TechnicalAttributes6.TechnicalAttributes6Builder prune();
	}

	/*********************** Immutable Implementation of TechnicalAttributes6  ***********************/
	class TechnicalAttributes6Impl implements TechnicalAttributes6 {
		private final String techRcrdId;
		private final ZonedDateTime rptRctTmStmp;
		
		protected TechnicalAttributes6Impl(TechnicalAttributes6.TechnicalAttributes6Builder builder) {
			this.techRcrdId = builder.getTechRcrdId();
			this.rptRctTmStmp = builder.getRptRctTmStmp();
		}
		
		@Override
		@RosettaAttribute("techRcrdId")
		@Accessor(AccessorType.GETTER)
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
		public TechnicalAttributes6 build() {
			return this;
		}
		
		@Override
		public TechnicalAttributes6.TechnicalAttributes6Builder toBuilder() {
			TechnicalAttributes6.TechnicalAttributes6Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TechnicalAttributes6.TechnicalAttributes6Builder builder) {
			ofNullable(getTechRcrdId()).ifPresent(builder::setTechRcrdId);
			ofNullable(getRptRctTmStmp()).ifPresent(builder::setRptRctTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TechnicalAttributes6 _that = getType().cast(o);
		
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
			return "TechnicalAttributes6 {" +
				"techRcrdId=" + this.techRcrdId + ", " +
				"rptRctTmStmp=" + this.rptRctTmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of TechnicalAttributes6  ***********************/
	class TechnicalAttributes6BuilderImpl implements TechnicalAttributes6.TechnicalAttributes6Builder {
	
		protected String techRcrdId;
		protected ZonedDateTime rptRctTmStmp;
		
		@Override
		@RosettaAttribute("techRcrdId")
		@Accessor(AccessorType.GETTER)
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
		@RuneAttribute("techRcrdId")
		@Override
		public TechnicalAttributes6.TechnicalAttributes6Builder setTechRcrdId(String _techRcrdId) {
			this.techRcrdId = _techRcrdId == null ? null : _techRcrdId;
			return this;
		}
		
		@RosettaAttribute("rptRctTmStmp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rptRctTmStmp")
		@Override
		public TechnicalAttributes6.TechnicalAttributes6Builder setRptRctTmStmp(ZonedDateTime _rptRctTmStmp) {
			this.rptRctTmStmp = _rptRctTmStmp == null ? null : _rptRctTmStmp;
			return this;
		}
		
		@Override
		public TechnicalAttributes6 build() {
			return new TechnicalAttributes6.TechnicalAttributes6Impl(this);
		}
		
		@Override
		public TechnicalAttributes6.TechnicalAttributes6Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TechnicalAttributes6.TechnicalAttributes6Builder prune() {
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
		public TechnicalAttributes6.TechnicalAttributes6Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TechnicalAttributes6.TechnicalAttributes6Builder o = (TechnicalAttributes6.TechnicalAttributes6Builder) other;
			
			
			merger.mergeBasic(getTechRcrdId(), o.getTechRcrdId(), this::setTechRcrdId);
			merger.mergeBasic(getRptRctTmStmp(), o.getRptRctTmStmp(), this::setRptRctTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TechnicalAttributes6 _that = getType().cast(o);
		
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
			return "TechnicalAttributes6Builder {" +
				"techRcrdId=" + this.techRcrdId + ", " +
				"rptRctTmStmp=" + this.rptRctTmStmp +
			'}';
		}
	}
}
